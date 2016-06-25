package com.oocl.mnlbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;

public class DatabaseTransactions {

   private static Connection getConn() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String username = "system";
      String password = "august22"; // change password of your database system
      Connection conn = null;
      try {
         Class.forName(driver); // classLoader,加载对应驱动
         conn = (Connection) DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return conn;
   }

   public static Client getChatUser(String username, String password) {
      Connection conn = getConn();
      Client client = null;

      String sql = "SELECT * FROM CHAT_USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            String id = rs.getString("USER_ID");
            String firstName = rs.getString("FIRST_NAME");
            String lastName = rs.getString("LAST_NAME");
            if (!id.equals("")) {
               client = new Client(id, firstName, lastName, username, password);
               pstmt.close();
               conn.close();
               return client;
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return client;
   }
   
   public static List<Client> getOnlineUsers() {
	      Connection conn = getConn();
	      ResultSet rs = null;
	      List<Client> clients = new ArrayList<Client>();

	      String sql = "SELECT * FROM CHAT_USERS WHERE CONN_TIMESTAMP IS NOT NULL ORDER BY CONN_TIMESTAMP";
	      PreparedStatement pstmt;
	      try {
	         pstmt = (PreparedStatement) conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            String id = rs.getString("USER_ID");
	            String firstName = rs.getString("FIRST_NAME");
	            String lastName = rs.getString("LAST_NAME");
	            String username = rs.getString("USERNAME");
	            String password = rs.getString("PASSWORD");
	            if (!id.equals("")) {
	            	Client client = new Client(id,username,password,firstName,lastName);
	            	clients.add(client);
	               pstmt.close();
	               conn.close();
	            }
	         }
	         return clients;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return clients;
	}
   
   public static int declareOnline(Client client, String connTimestamp){
	   Connection conn = getConn();
	   int result = 0;
	   String userID = client.getId();
	   String sql = "UPDATE CHAT_USERS SET CONN_TIMESTAMP='" + connTimestamp + "' WHERE USER_ID ='" + userID + "'";
	   PreparedStatement pstmt;
	   try {
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return result;
   }
   
   public static int declareOffline(Client client, String connTimestamp){
	   Connection conn = getConn();
	   int result = 0;
	   String userID = client.getId();
	   String sql = "UPDATE CHAT_USERS SET CONN_TIMESTAMP = NULL WHERE USER_ID ='" + userID + "'";
	   PreparedStatement pstmt;
	   try {
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return result;
   }

   public static boolean verifyChatUser(String username) {
      Connection conn = getConn();
      Client client = null;

      String sql = "SELECT * FROM CHAT_USERS WHERE USERNAME='" + username + "'";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            String id = rs.getString("USER_ID");
            String firstName = rs.getString("FIRST_NAME");
            String lastName = rs.getString("LAST_NAME");
            String password = rs.getString("PASSWORD");
            if (!id.equals("")) {
               client = new Client(id, firstName, lastName, username, password);
               pstmt.close();
               conn.close();
               return true;
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   public static int createUser(Client client) {
      Connection conn = getConn();
      int result = 0;

      String username = client.getUsername();
      String password = client.getPassword();
      String fname = client.getFname();
      String lname = client.getLname();

      String sql = "INSERT INTO CHAT_USERS(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,ACTIVE) VALUES('" + username + "','"
         + password + "','" + fname + "','" + lname + "','1')";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         result = pStmt.executeUpdate();
         pStmt.close();
         conn.close();
         return result;
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return result;
   }

   public static int createSession(Session session) {
      Connection conn = getConn();
      int result = 0;

      String startDT = session.getStart();
      String sql = "INSERT INTO CHAT_SESSION(START_DT,ACTIVE) VALUES('" + startDT + "','1')";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         result = pStmt.executeUpdate();
         pStmt.close();
         conn.close();
         return result;
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return result;
   }

   public static int saveMessage(Message message) {
      Connection conn = getConn();
      int result = 0;
      long sender = message.getClientId();
      String messageData = message.getMessage();
      long sessionID = message.getSessionId();
      String dateTime = message.getTimestamp();

      String sql = "INSERT INTO CHAT_MESSAGE(MESSAGE_SENDER,MESSAGE,SESSION_ID,MESSAGE_DT) VALUES('" + sender + "','"
         + messageData + "','" + sessionID + "','" + dateTime + "')";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         result = pStmt.executeUpdate();
         pStmt.close();
         conn.close();
         return result;
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return result;
   }

   public static int endSession(long sessionID, String endDT) {
      Connection conn = getConn();
      int result = 0;

      String sql = "UPDATE CHAT_SESSION SET END_DT ='" + endDT + "' ACTIVE ='0' WHERE SESSION_ID='" + sessionID + "'";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         result = pStmt.executeUpdate();
         pStmt.close();
         conn.close();
         return result;
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return result;
   }

   public static long getActiveSessionID() {
      Connection conn = getConn();
      long sessionID = 0;
      String sql = "SELECT SESSION_ID FROM CHAT_SESSION WHERE ACTIVE='1'";
      PreparedStatement pstmt;
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            String id = rs.getString("SESSION_ID");
            if (!id.equals("")) {
               sessionID = Integer.parseInt(id);
               return sessionID;
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return sessionID;
   }

}
