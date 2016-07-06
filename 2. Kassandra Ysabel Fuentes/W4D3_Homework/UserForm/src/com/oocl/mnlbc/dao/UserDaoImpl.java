package com.oocl.mnlbc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oocl.mnlbc.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

	private DataSource ds;
	
	public UserDaoImpl() {

		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/xe");
		}
		catch(NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred in database configuration", e);
		}

	}

	private Connection openConnection() throws SQLException {
		return ds.getConnection();
	}
	
	@Override
	public List<User> getAllUser() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		
		try {
			conn = openConnection();
			
			Statement stmt = conn.createStatement();
		
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			while(rs.next()) {
			   User usr = new User();
				usr.setId( rs.getString("id") );
				usr.setFirstName( rs.getString("first_name") );
				usr.setLastName( rs.getString("last_name") );
				usr.setAddress(rs.getString("address"));
				usr.setEmail(rs.getString("email"));
				usr.setUserName(rs.getString("username"));
				usr.setPassword(rs.getString("password"));

				userList.add(usr);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			// close the connection
			try { 
				if(conn != null) conn.close(); 
			} catch (SQLException ignore) {}
			throw new RuntimeException("An error occurred while connecting to database", e);
		}

		return userList;
	}

	@Override
	public User getUserById(String id) {
		Connection conn = null;
		User usr = null;
		
		try {
			conn = openConnection();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				usr = new User();
				usr.setId( rs.getString("id") );
	         usr.setFirstName( rs.getString("first_name") );
	         usr.setLastName( rs.getString("last_name") );
	         usr.setAddress(rs.getString("address"));
	         usr.setEmail(rs.getString("email"));
	         usr.setUserName(rs.getString("username"));
	         usr.setPassword(rs.getString("password"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return usr;
		}
		catch(SQLException e) {
			e.printStackTrace();
			// close the connection
			try { 
				if(conn != null) conn.close(); 
			} catch (SQLException ignore) {}
			throw new RuntimeException("An error occurred while connecting to database", e);
		}
	}

	@Override
	public void addUser(User data) {
		Connection conn = null;
		User usr = null;
		
		try {
			conn = openConnection();
			
			PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO users (id, first_name, last_name, address, email, username, password) "
				+ "VALUES (?, ?, ?, ?, ?, ?,?)");
			
			stmt.setString(1, data.getId());
         stmt.setString(2, data.getFirstName());
			stmt.setString(3, data.getLastName());
			stmt.setString(4, data.getAddress());
			stmt.setString(5, data.getEmail());
			stmt.setString(6, data.getUserName());
			stmt.setString(7, data.getPassword());
			
			int count = stmt.executeUpdate();
			
			stmt.close();
			conn.close();

			if(count==0) {
				throw new RuntimeException("No record was added.");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			// close the connection
			try { 
				if(conn != null) conn.close(); 
			} catch (SQLException ignore) {}
			throw new RuntimeException("An error occurred while connecting to database", e);
		}
	}

	@Override
	public void updateUser(User data) {
		Connection conn = null;
		User usr = null;
		
		try {
			conn = openConnection();
			
			PreparedStatement stmt = conn.prepareStatement(
				"UPDATE users SET first_name=?, last_name=?, address=?, email=?, username=?, password=? WHERE id=?");
			
			   stmt.setString(1, data.getId());
            stmt.setString(2, data.getFirstName());
	         stmt.setString(3, data.getLastName());
	         stmt.setString(4, data.getAddress());
	         stmt.setString(5, data.getEmail());
	         stmt.setString(6, data.getUserName());
	         stmt.setString(7, data.getPassword());
			
			int count = stmt.executeUpdate();
			
			stmt.close();
			conn.close();

			if(count==0) {
				throw new RuntimeException("No record was updated.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			// close the connection
			try { 
				if(conn != null) conn.close(); 
			} catch (SQLException ignore) {}
			throw new RuntimeException("An error occurred while connecting to database", e);
		}
	}

	@Override
	public void deleteUser(String id) {
		Connection conn = null;
		
		try {
			conn = openConnection();
			
			PreparedStatement stmt = conn.prepareStatement(
				"DELETE FROM users WHERE id=?");
			
			stmt.setString(1, id);
			
			int count = stmt.executeUpdate();
			
			stmt.close();
			conn.close();

			if(count==0) {
				throw new RuntimeException("No record was deleted.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			// close the connection
			try { 
				if(conn != null) conn.close(); 
			} catch (SQLException ignore) {}
			throw new RuntimeException("An error occurred while connecting to database", e);
		}
	}


   public boolean validateUser(String email, String username) {
      Connection conn = null;
      boolean check = false;
      
      try {
         conn = openConnection();
         
         PreparedStatement stmt = conn.prepareStatement("select * from users where username=?  and email= ?");
         
         stmt.setString(1, username);
         stmt.setString(2, email);
         
         ResultSet rs = stmt.executeQuery();
         
         check = rs.next();
         
         rs.close();
         stmt.close();
         conn.close();
         
         return check;
         
      }
      catch(SQLException e) {
         e.printStackTrace();
         // close the connection
         try { 
            if(conn != null) conn.close(); 
         } catch (SQLException ignore) {}
         throw new RuntimeException("An error occurred while connecting to database", e);
      }
      
   }
   
   public boolean checkUserCredentials(String username, String password) {
      Connection conn = null;
      boolean st = false;

      try {
         conn = openConnection();
         
         PreparedStatement stmt = conn.prepareStatement( "select username from users where username='"
               + username + "' and password ='" + password + "'");
         ResultSet rs = stmt.executeQuery();

         st = rs.next();

      }

      catch (SQLException e) {
         System.out.println(e.getMessage());
      }
      return st;
}

}
