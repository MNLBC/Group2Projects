package com.mnlbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB Connection Util
 * 
 * @author WILLIAM
 * @since 2016-07-09
 */
public class DbConnection {

   public Connection getConn() {
      String driver = Config.getConfigValue("driver");
      String url = Config.getConfigValue("url");
      String username = Config.getConfigValue("user");
      String password = Config.getConfigValue("pass");
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
}
