package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.util.DbConnection;
/**
 * 
 * @author kalinwi2
 * DAO Implementation for USER TABLE
 *
 */
public class UserDAOImpl implements UserDAO {

   DbConnection dbConnect = new DbConnection();
   
	@Override
	public boolean validateUser(String email) {
		Connection conn = dbConnect.getConn();
		boolean result = false;
		String sql = "SELECT USERID FROM USERS WHERE USEREMAIL = ?";
		
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
		String sql = "SELECT * FROM USERS WHERE USEREMAIL = ? AND USERPASS = ?";
		
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
					user.setUserFname(rs.getString("USERFNAME"));
					user.setUserLname(rs.getString("USERLNAME"));
					user.setUserEmail(rs.getString("USEREMAIL"));
					user.setUserPass(rs.getString("USERPASS"));
					user.setUserStreet(rs.getString("USERSTREET"));
					user.setUserCity(rs.getString("USERCITY"));
					user.setUserCountry(rs.getString("USERCOUNTRY"));
					user.setUserType(rs.getString("USERTYPE"));
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
		String sql = "INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERSTREET,USERCITY,USERCOUNTRY,USERTYPE)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserFname());
			pStmt.setString(2, user.getUserLname());
			pStmt.setString(3, user.getUserEmail());
			pStmt.setString(4, user.getUserPass());
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
	public int updateUserType(User user,String type) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "UPDATE USERS SET USERTYPE = ? WHERE USERID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, type);
			pStmt.setLong(2, user.getUserId());
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
	public List<Long> getBlackList() {
		List<Long> result = new ArrayList<Long>();		
		Connection conn = dbConnect.getConn();
		String sql = "SELECT * FROM USERS WHERE USERTYPE = 'BLACKLIST'";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!rs.getString("USERID").equals("")){
					result.add(rs.getLong("USERID"));
				}
			}
		}
		catch(SQLException e){
			
		}
		return result;
	}

	@Override
	public int deleteUser(User user) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "DELETE FROM USERS WHERE USERID = ?";
		
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