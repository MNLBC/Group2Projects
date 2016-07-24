package com.oocl.mnlbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.model.User;

/**
 * Stand-alone UserDAO for Blacklist Filter
 * @author KALINWI2
 * @since 21-JUL-2016
 */
public class TempUserDAOImpl {
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
	
	public List<User> getBlacklist(){
		List<User> blacklist = new ArrayList<User>();
		Connection conn = getConn();
		String sql = "SELECT * FROM USERS WHERE USERTYPE ='BLACKLIST'";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserEmail(rs.getString("USEREMAIL"));
				blacklist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return blacklist;
	}
}
