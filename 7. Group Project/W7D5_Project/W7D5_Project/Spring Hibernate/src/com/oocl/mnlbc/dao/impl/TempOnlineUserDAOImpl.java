package com.oocl.mnlbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.oocl.mnlbc.util.Timestamp;

public class TempOnlineUserDAOImpl {

   private Connection getConn() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@ZHA-ITA075-W7:1521:xe";
      String username = "GROUP2";
      String password = "GROUP2";
      Connection conn = null;
      try {
         Class.forName(driver);
         conn = (Connection) DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return conn;
   }
   
   public int deleteOnlineUser(String email) {
      Connection conn = getConn();
      int result = 0;
      String sql = "DELETE FROM ONLINEUSERS WHERE USEREMAIL = ?";
      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         pStmt.setString(1, email);
         result = pStmt.executeUpdate();
         pStmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }
}
