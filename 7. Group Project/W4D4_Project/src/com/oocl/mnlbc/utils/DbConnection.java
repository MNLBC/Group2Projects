package com.oocl.mnlbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
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
}
