package com.oocl.mnlbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.bean.User;

public class UserDAOImpl implements UserDAO {

	DatabaseConnection dbConnect = new DatabaseConnection();

	@Override
	public boolean validateUser(String email) {
		Connection conn = dbConnect.getConn();
		boolean result = false;
		String sql = "SELECT USERID FROM USERS WHERE EMAIL = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, email);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!rs.getString("USERID").equals("")){
					result = true;
					return result;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User getUser(String email, String password) {
		User user = new User();
		Connection conn = dbConnect.getConn();
		String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, email);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!rs.getString("USERID").equals("")){
					int id = Integer.parseInt(rs.getString("USERID"));
					user.setUserId((long) id);
					user.setUserFname(rs.getString("FNAME"));
					user.setUserLname(rs.getString("LNAME"));
					user.setUserEmail(rs.getString("EMAIL"));
					user.setUserPassword(rs.getString("PASSWORD"));
					user.setUserStreet(rs.getString("STREET"));
					user.setUserCity(rs.getString("CITY"));
					user.setUserCountry(rs.getString("COUNTRY"));
					user.setUserType(rs.getString("TYPE"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int createUser(User user) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "INSERT INTO USERS(FNAME,LNAME,EMAIL,PASSWORD,STREET,CITY,COUNTRY,TYPE)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserFname());
			pStmt.setString(2, user.getUserLname());
			pStmt.setString(3, user.getUserEmail());
			pStmt.setString(4, user.getUserPassword());
			pStmt.setString(5, user.getUserStreet());
			pStmt.setString(6, user.getUserCity());
			pStmt.setString(7, user.getUserCountry());
			pStmt.setString(8, user.getUserType());
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "";
		return 0;
	}

	@Override
	public int setActive(User user) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "UPDATE USERS SET ACTIVE = 1 WHERE USERID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, user.getUserId());
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int setInactive(User user) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "UPDATE USERS SET ACTIVE = 0 WHERE USERID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, user.getUserId());
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
