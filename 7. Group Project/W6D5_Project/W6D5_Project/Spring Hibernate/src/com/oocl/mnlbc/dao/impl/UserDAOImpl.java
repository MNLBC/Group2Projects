package com.oocl.mnlbc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.UserDAO;
import com.oocl.mnlbc.model.User;

/**
 * 
 * @author Danna Soquiat
 * @since 2016-07-16 
 * 
 * DAO Implementation for USER TABLE
 *
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@PersistenceContext
	private EntityManager manager;
	

	@Override
	public int createUser(User user) {
		manager.persist(user);
		logger.info("User saved successfully! User Details=" + user);
		return 1;
	}
	@Override
	public List<User> getAllUser(long userId, String userFname, String userLname, String userEmail,String userAddress1, String userAddress2, String userSp, int userLevel,String userOccup) {
	
	String sql = "SELECT user FROM USERS user";
	List<User> allUserList = manager.createQuery(sql).getResultList();
	for (User allUser : allUserList) {
		logger.info("User Email List:" + allUser);
	}
	return allUserList;
}
		

	@Override
	public User getUser(String email, String password) {
		String sql = "SELECT user.USEREMAIL, user.USERPASS FROM USERS user" + " WHERE user.USEREMAIL='" + email + "' AND user.USERPASS='" + password + "'";
		User user = manager.createQuery(sql, User.class).getSingleResult();
		
//		User user = (User) session	.createQuery(sql).uniqueResult();

		logger.info("User email and password" + email + password);
		return user;
	}
	@Override
	public List<User> getUserByEmail(String email) {
		String sql = "SELECT useremail FROM USERS useremail" + "WHERE useremail.USEREMAIL='" + email + "'";
		List<User> userEmailList = manager.createQuery(sql).getResultList();
		for (User userEmail : userEmailList) {
			logger.info("User Email List:" + userEmail);
		}
		return userEmailList;
	}
	@Override
	public List<User> getUserBlackList() {
		String sql = "SELECT user FROM USERS user WHERE user.USERTYPE='BLACKLIST'";
		List<User> blackList = manager.createQuery(sql).getResultList();
		for (User userblacklist : blackList) {
			logger.info("Blacklisted user:" + userblacklist);
		}
		return blackList;
	}
	@Override
	public int updateUser(User user) {

//		Session session = this.sessionFactory.getCurrentSession();
//		session.update(user);
//		logger.info("User updated successfully! User details:" + user);
//		return 1;
		
		User newUser = manager.find(User.class, user.getUserId());
		newUser = user;
		logger.info("Product updated successfully!=" + newUser);
		return 1;
	}
	@Override
	public int deleteUser(long id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		User user = (User) session.load(User.class, new Long(id));
//
//		if (null != user) {
//			session.delete(user);
			
			
			User deletedUser = manager.find(User.class, id);
			manager.remove(deletedUser);
			logger.info("User deleted successfully!=" + deletedUser);
			return 1;

	}

	@Override
	public boolean validateUser(String email) {
		String sql = "SELECT user FROM USERS user" + "WHERE user.USEREMAIL='" + email + "'";
		User user = (User) manager.createQuery(sql).getSingleResult();
		

		if (user != null) {
			return true;
		}

		logger.info("User email address is:" + email);
		return false;
	}
	
	@Override
	public List<User> getPremiumUser() {
		String sql = "SELECT premiumuser FROM USERS premiumuser WHERE premiumuser.USERLEVEL=2";
		List<User> premiumUserList = manager.createQuery(sql).getResultList();
		for (User premiumUser : premiumUserList) {
			logger.info("Premium User List:" + premiumUserList);
		}
		return premiumUserList;
	}		
}
