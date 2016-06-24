package com.oocl.mnlbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oocl.mnlbc.models.*;

public class DatabaseTransactions {
   
   private static Connection getConn() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String username = "system";
      String password = "admin"; //change password of your database system
      Connection conn = null;
      try {
          Class.forName(driver); //classLoader,加载对应驱动
          conn = (Connection) DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return conn;
  }
   
   public static Client getChatUser(String username,String password) {
      Connection conn = getConn();
      Client client = null;
      
      String sql = "SELECT * FROM CHAT_USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";
      PreparedStatement pstmt;
      try {
          pstmt = (PreparedStatement)conn.prepareStatement(sql);
          ResultSet rs = pstmt.executeQuery();
          while (rs.next()) {
              String id = rs.getString("USER_ID");
              if(!id.equals("")){
                 client.setId(id);
                 client.setUsername(rs.getString("USERNAME"));
                 client.setPassword(rs.getString("PASSWORD"));
                 client.setFname(rs.getString("FIRST_NAME"));
                 client.setLname(rs.getString("LAST_NAME"));   
                 pstmt.close();
                 conn.close();
                 return client;
              }
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }
   
  public static int createUser(Client client){
     Connection conn = getConn();
     int result = 0;
     
     String username = client.getUsername();
     String password = client.getPassword();
     String fname = client.getFname();
     String lname = client.getLname();
     
     String sql = "INSERT INTO CHAT_USERS(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,ACTIVE) VALUES('"+username+"','"+password+"','"+fname+"','"+lname+"','1')";
     PreparedStatement pStmt;
     try {
      pStmt = (PreparedStatement)conn.prepareStatement(sql);
      result = pStmt.executeUpdate();
      pStmt.close();
      conn.close();
      return result;
   } catch (SQLException e) {
      e.printStackTrace();
   }
     
     return result;
  }
   
  public static int createSession(Session session){
     Connection conn = getConn();
     int result = 0;
     List<Client> clients = session.getClientList();
     String clientNames = "";
     for(int i = 0; i < clients.size(); i++){
        clientNames = clientNames + clients.get(i).getFname() + " " + clients.get(i).getLname() + "(" + clients.get(i).getUsername() + ")";
        if(i != clients.size() - 1){
           clientNames = clientNames + " | ";
        }
     }
     String dateTime = session.getTimestamp();
     String sql = "INSERT INTO CHAT_SESSION(INVOLVED_CLIENTS,CREATE_DT,ACTIVE) VALUES('"+ clientNames +"','" + dateTime + "','1')";
     PreparedStatement pStmt;
     try {
      pStmt = (PreparedStatement)conn.prepareStatement(sql);
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
  
  public static int saveMessage(Message message){
     Connection conn = getConn();
     int result = 0;
     long sender = message.getClientId();
     String messageData = message.getMessage();
     long sessionID = message.getSessionId();
     String dateTime = message.getTimestamp();     
     
     String sql = "INSERT INTO CHAT_MESSAGE(MESSAGE_SENDER,MESSAGE,SESSION_ID,MESSAGE_DT) VALUES('"+sender+"','"+messageData+"','"+sessionID+"','"+dateTime+"')";
     PreparedStatement pStmt;
     try {
      pStmt = (PreparedStatement)conn.prepareStatement(sql);
      result = pStmt.executeUpdate();
      pStmt.close();
      conn.close();
      return result;
   } catch (SQLException e) {
      e.printStackTrace();
   }
     
     return result;
  }
  
  public static int endSession(long sessionID){
     Connection conn = getConn();
     int result = 0;    
     
     String sql = "UPDATE CHAT_SESSION SET ACTIVE ='0' WHERE SESSION_ID='"+sessionID+"'";
     PreparedStatement pStmt;
     try {
      pStmt = (PreparedStatement)conn.prepareStatement(sql);
      result = pStmt.executeUpdate();
      pStmt.close();
      conn.close();
      return result;
   } catch (SQLException e) {
      e.printStackTrace();
   }
     
     return result;
  }
  
  public static long getSessionID(){
     Connection conn = getConn();
     long sessionID = 0;
     String sql = "SELECT * FROM CHAT_SESSION WHERE ACTIVE='1'";
     PreparedStatement pstmt;
     try {
         pstmt = (PreparedStatement)conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
             String id = rs.getString("SESSION_ID");
             if(!id.equals("")){
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
