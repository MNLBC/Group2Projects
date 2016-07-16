package com.oocl.mnlbc.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.oocl.mnlbc.model.User;
/**
 * 
 * @author Danna Soquiat
 * @since 2016-07-16
 * DAO Implementation for USER TABLE
 *
 */
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory=sf;
	}
	
	@Override
	public void createUser(User user){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully! User Details=" + user);
	}
	
	@Override
	public User getUser (String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql=" SELECT * FROM USER"
				+" WHERE USEREMAIL=" + email
				+" AND USERPASS=" + password;
		User user = (User) session.createQuery(sql);
		
		logger.info("User email and password" + email + password);
		return user;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> getUserByEmail(String email){
		Session session = this.sessionFactory.getCurrentSession();
		String sql="SELECT * FROM USER"
					+ "WHERE USEREMAIL=" +email;
		List<User> userEmailList = session.createQuery(sql).list();
		logger.info("Email :"+email);
		 for (User userEmail : userEmailList){
			 logger.info("User email list: " + userEmail);
		 }
		 return userEmailList;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation", "unused" })
	@Override
	public List<User> getUserBlackList(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM USER"
					+ "WHERE USERTYPE=" + "BLACKLIST";
		List<User> blackList  = session.createQuery(sql).list();
		logger.info("User Id:"+user.getUserId());
		for(User userblacklist : blackList){
			logger.info("Blacklisted user:"+user);
		}
		return blackList;
	}
	
	@Override
	public void updateUser(User user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user); 
		logger.info("User updated successfully! User details:" + user);
	}
	
	@Override
	public void deleteUser(int id){
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		
	if (null != user){
		session.delete(user);
	}
	logger.info("User deleted successfully, User detail:" +user);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean validateUser (String email){
			Session session = this.sessionFactory.getCurrentSession();
			String sql="SELECT * FROM USER"
						+ "WHERE USEREMAIL=" + email;
			List<User> userList = session.createQuery(sql).list();
			
			if (userList.size() == 0){
				return true;
			}

			 logger.info("User email address is:" + email);
			 return false;
		}
	}
//   DbConnection dbConnect = new DbConnection();
//   
//	@Override
//	public boolean validateUser(String email) {
//		Connection conn = dbConnect.getConn();
//		boolean result = false;
//		String sql = "SELECT USERID FROM USERS WHERE USEREMAIL = ?";
//		
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			pStmt.setString(1, email);
//			ResultSet rs = pStmt.executeQuery();
//			while(rs.next()){
//				if(!rs.getString("USERID").equals("")){
//					result = true;
//					return result;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@Override
//	public User getUser(String email, String password) {
//		User user = new User();
//		Connection conn = dbConnect.getConn();
//		String sql = "SELECT * FROM USERS WHERE USEREMAIL = ? AND USERPASS = ?";
//		
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			pStmt.setString(1, email);
//			pStmt.setString(2, password);
//			ResultSet rs = pStmt.executeQuery();
//			while(rs.next()){
//				if(!rs.getString("USERID").equals("")){
//					int id = Integer.parseInt(rs.getString("USERID"));
//					user.setUserId((long) id);
//					user.setUserFname(rs.getString("USERFNAME"));
//					user.setUserLname(rs.getString("USERLNAME"));
//					user.setUserEmail(rs.getString("USEREMAIL"));
//					user.setUserPass(rs.getString("USERPASS"));
//					user.setUserStreet(rs.getString("USERSTREET"));
//					user.setUserCity(rs.getString("USERCITY"));
//					user.setUserCountry(rs.getString("USERCOUNTRY"));
//					user.setUserType(rs.getString("USERTYPE"));
//					return user;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}
//	
//	  @Override
//	   public User getUserByEmail(String email) {
//	      User user = new User();
//	      Connection conn = dbConnect.getConn();
//	      String sql = "SELECT * FROM USERS WHERE USEREMAIL = ?";
//	      
//	      PreparedStatement pStmt;
//	      try {
//	         pStmt = (PreparedStatement) conn.prepareStatement(sql);
//	         pStmt.setString(1, email);
//	         ResultSet rs = pStmt.executeQuery();
//	         while(rs.next()){
//	            if(!rs.getString("USERID").equals("")){
//	               int id = Integer.parseInt(rs.getString("USERID"));
//	               user.setUserId((long) id);
//	               user.setUserFname(rs.getString("USERFNAME"));
//	               user.setUserLname(rs.getString("USERLNAME"));
//	               user.setUserEmail(rs.getString("USEREMAIL"));
//	               user.setUserPass(rs.getString("USERPASS"));
//	               user.setUserStreet(rs.getString("USERSTREET"));
//	               user.setUserCity(rs.getString("USERCITY"));
//	               user.setUserCountry(rs.getString("USERCOUNTRY"));
//	               user.setUserType(rs.getString("USERTYPE"));
//	               return user;
//	            }
//	         }
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      }
//	      return user;
//	   }
//
//	@Override
//	public int createUser(User user) {
//		int result = 0;
//		Connection conn = dbConnect.getConn();
//		String sql = "INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERSTREET,USERCITY,USERCOUNTRY,USERTYPE)"
//				+ "VALUES(?,?,?,?,?,?,?,?)";
//		
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			pStmt.setString(1, user.getUserFname());
//			pStmt.setString(2, user.getUserLname());
//			pStmt.setString(3, user.getUserEmail());
//			pStmt.setString(4, user.getUserPass());
//			pStmt.setString(5, user.getUserStreet());
//			pStmt.setString(6, user.getUserCity());
//			pStmt.setString(7, user.getUserCountry());
//			pStmt.setString(8, user.getUserType());
//			result = pStmt.executeUpdate();
//			pStmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return result;
//	}
//
//	@Override
//	public int updateUserType(User user,String type) {
//		int result = 0;
//		Connection conn = dbConnect.getConn();
//		String sql = "UPDATE USERS SET USERTYPE = ? WHERE USERID = ?";
//		
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			pStmt.setString(1, type);
//			pStmt.setLong(2, user.getUserId());
//			result = pStmt.executeUpdate();
//			pStmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return result;
//	}
//
//
//	@Override
//	public List<Long> getBlackList() {
//		List<Long> result = new ArrayList<Long>();		
//		Connection conn = dbConnect.getConn();
//		String sql = "SELECT * FROM USERS WHERE USERTYPE = 'BLACKLIST'";
//		
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet rs = pStmt.executeQuery();
//			while(rs.next()){
//				if(!rs.getString("USERID").equals("")){
//					result.add(rs.getLong("USERID"));
//				}
//			}
//		}
//		catch(SQLException e){
//			
//		}
//		return result;
//	}
//
//	@Override
//	public int deleteUser(User user) {
//		int result = 0;
//		Connection conn = dbConnect.getConn();
//		String sql = "DELETE FROM USERS WHERE USERID = ?";
//		
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			pStmt.setLong(1, user.getUserId());
//			result = pStmt.executeUpdate();
//			pStmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return result;
//	}

//	@Override
//	public int deleteUser(User user) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int updateUserType(User user, String type) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public List<Long> getBlackList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}