package com.oocl.mnlbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.models.*;

public class DatabaseTransactions {
   
   private static Connection getConn() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521/xe";
      String username = "system";
      String password = "august22"; //change password of your database system
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
     
     String sql = "INSERT INTO CHAT_USERS(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME) VALUES('?','?','?','?')";
     PreparedStatement pStmt;
     try {
      pStmt = (PreparedStatement)conn.prepareStatement(sql);
      pStmt.setString(1, username);
      pStmt.setString(2, password);
      pStmt.setString(3, fname);
      pStmt.setString(4, lname);
      result = pStmt.executeUpdate();
      pStmt.close();
      conn.close();
      return result;
   } catch (SQLException e) {
      e.printStackTrace();
   }
     
     return result;
  }
   
  public static int createSession(String dateTime){
     Connection conn = getConn();
     int result = 0;
     
     String sql = "INSERT INTO CHAT_SESSION(SESSION_DESC,CREATE_DT) VALUES('Sample Description for session','" + dateTime + "')";
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
  
  public static int saveMessage(){
     Connection conn = getConn();
     int result = 0;
     
     String sql = "INSERT INTO CHAT_MESSAGE(MESSAGE_SENDER,MESSAGE,SESSION_ID,";
     
     return result;
  }

}
