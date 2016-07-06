package com.oocl.mnlbc.w4d3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
	private static Connection getConn() {
	      String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String username = "testacct";
	      String password = "abc";
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
	
	public boolean userFound(String username){
		boolean result = false;
		Connection conn = getConn();
		
		String sql = "SELECT * FROM W4D3_USERS WHERE USERNAME = ?";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!rs.getString("USERNAME").equals("")){
					result = true;
					return result;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int createAccount(String firstname, String lastname, String username, String password){
		int result = 0;
		Connection conn = getConn();
		
		String sql = "INSERT INTO W4D3_USERS(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME) VALUES(?,?,?,?)";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			pStmt.setString(3, firstname);
			pStmt.setString(4, lastname);
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
