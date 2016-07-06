package com.oocl.mnlbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

   public static boolean checkUser(String uname){
      Connection conn = getConn();
      PreparedStatement pstmt;
      ResultSet rs;
      String result;
      String sql = "SELECT uname FROM W4D3_USERS";
      
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()){
            if(rs.getString(1).equals(uname)){
               return true;
            }
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return false;
   }
   
   public static void registerUser(String fname, String lname, String email, String uname, String pword){
      Connection conn = getConn();
      PreparedStatement pstmt;
      String sql = "INSERT INTO W4D3_USERS VALUES(?,?,?,?,?)";
      
      try {
         pstmt = (PreparedStatement) conn.prepareStatement(sql);
         pstmt.setString(1, fname);
         pstmt.setString(2, lname);
         pstmt.setString(3, email);
         pstmt.setString(4, uname);
         pstmt.setString(5, pword);
         pstmt.executeUpdate();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public static Connection getConn(){
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String username = "system";
      String password = "Zenf0ne2";
      Connection conn = null;
      
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return conn;
   }
}
