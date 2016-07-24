package com.oocl.mnlbc.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.UserDAO;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.util.PasswordHash;

/**
 * 
 * @author Danna Soquiat
 * @since 2016-07-16
 * 
 *        DAO Implementation for USER TABLE
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
	public List<User> getAllUser() {

		String sql = "SELECT user FROM User user";
		List<User> allUserList = manager.createQuery(sql).getResultList();
		for (User allUser : allUserList) {
			logger.info("User Email List:" + allUser);
		}
		return allUserList;
	}

	@Override
	public User getUser(String email, String password) {
		String sql = "SELECT user.USEREMAIL, user.USERPASS FROM User user WHERE user.userEmail='" + email
				+ "' AND user.userPass='" + password + "'";
		User user = manager.createQuery(sql, User.class).getSingleResult();

		logger.info("User email and password" + email + password);
		return user;
	}

	@Override
	public List<User> getUserByEmail(String email) {
		String sql = "SELECT useremail FROM User useremail WHERE useremail.userEmail='" + email + "'";
		List<User> userEmailList = manager.createQuery(sql).getResultList();
		for (User userEmail : userEmailList) {
			logger.info("User Email List:" + userEmail);
		}
		return userEmailList;
	}

	@Override
	public List<User> getUserBlackList() {
		String sql = "SELECT user FROM User user WHERE user.userType='BLACKLIST'";
		List<User> blackList = manager.createQuery(sql).getResultList();
		for (User userblacklist : blackList) {
			logger.info("Blacklisted user:" + userblacklist);
		}
		return blackList;
	}

	@Override
	public int updateUser(User user) {

		User newUser = manager.find(User.class, user.getUserId());
		newUser.setUserId(user.getUserId());
		newUser.setUserFname(user.getUserFname());
		newUser.setUserLname(user.getUserLname());
		newUser.setUserEmail(user.getUserEmail());
		newUser.setUserAddress1(user.getUserAddress1());
		newUser.setUserAddress2(user.getUserAddress2());
		newUser.setUserSp(user.getUserSp());
		newUser.setUserLevel(user.getUserLevel());
		newUser.setUserOccupation(user.getUserOccupation());
		newUser.setUserCity(user.getUserCity());
		newUser.setUserCountry(user.getUserCountry());
		newUser.setUserPass(user.getUserPass());
		newUser.setUserType(user.getUserType());
		logger.info("Product updated successfully!=" + newUser);
		return 1;
	}

	@Override
	public int deleteUser(long id) {

		User deletedUser = manager.find(User.class, id);
		manager.remove(deletedUser);
		logger.info("User deleted successfully!=" + deletedUser);
		return 1;

	}

	@Override
	public boolean validateUser(String email, String password) {
//		String sql = "SELECT user FROM User user WHERE user.userEmail='" + email + "' AND user.userPass='" + password + "'";
//		List<User> user = manager.createQuery(sql).getResultList();
	   String sql = "SELECT user FROM User user WHERE user.userEmail='" + email + "'";
	   List<User> user = manager.createQuery(sql).getResultList();
		if (!user.isEmpty()) {
	      try {
            if(PasswordHash.validatePassword(password, user.get(0).getUserPass()))
               return true;
         } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error(e.getMessage());
         }
		}

		logger.info("User email address is:" + email);
		return false;
	}

	@Override
	public List<User> getPremiumUser() {
		String sql = "SELECT premiumuser FROM User premiumuser WHERE premiumuser.userLevel=2";
		List<User> premiumUserList = manager.createQuery(sql).getResultList();
		for (User premiumUser : premiumUserList) {
			logger.info("Premium User List:" + premiumUserList);
		}
		return premiumUserList;
	}

	@Override
	public int updateToPremium(String email) {
		int result = 0;
		logger.info("Updating account to premium: " + email);
		try{
			result = manager.createNativeQuery("UPDATE USERS SET USERLEVEL = 2 WHERE USEREMAIL ='" + email +"'").executeUpdate();
		} catch(Exception e){
			logger.info("New Premium Account: " + email);
			e.printStackTrace();
		}
		return result;
	}
}
