package com.oocl.mnlbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.util.Timestamp;

/**
 * Temporary DAO for create Request
 * @author KALINWI2
 * 
 */

public class TempRequestDAOImpl {
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
	
	public int createRequest(String email){
		Connection conn = getConn();
		int result = 0;
		String sql = "INSERT INTO REQUESTS(USERMAIL,REQDATE,REQSTATUS) VALUES('" + email +"','"
				+ Timestamp.getTimestamp() + "','PENDING')";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
