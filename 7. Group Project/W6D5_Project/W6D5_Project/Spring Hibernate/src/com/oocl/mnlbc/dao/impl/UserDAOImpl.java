package com.oocl.mnlbc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.UserDAO;
import com.oocl.mnlbc.model.User;

/**
 * 
 * @author Danna Soquiat
 * @since 2016-07-16 DAO Implementation for USER TABLE
 *
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public int createUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully! User Details=" + user);
		return 1;
	}

	@Override
	public User getUser(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "FROM User" + " WHERE USEREMAIL='" + email + "' AND USERPASS='" + password + "'";
		User user = (User) session.createQuery(sql).uniqueResult();

		logger.info("User email and password" + email + password);
		return user;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> getUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "FROM User" + "WHERE USEREMAIL='" + email + "'";
		List<User> userEmailList = session.createQuery(sql).list();
		logger.info("Email :" + email);
		for (User userEmail : userEmailList) {
			logger.info("User email list: " + userEmail);
		}
		return userEmailList;
	}

	@SuppressWarnings({ "unchecked", "deprecation", "unused" })
	@Override
	public List<User> getUserBlackList() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "FROM User WHERE USERTYPE='BLACKLIST'";
		List<User> blackList = session.createQuery(sql).list();

		for (User userblacklist : blackList) {
			logger.info("Blacklisted user:" + userblacklist);
		}
		return blackList;
	}

	@Override
	public int updateUser(User user) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully! User details:" + user);
		return 1;
	}

	@Override
	public int deleteUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long(id));

		if (null != user) {
			session.delete(user);

		}
		logger.info("User deleted successfully, User detail:" + user);
		return 1;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean validateUser(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "FROM User" + "WHERE USEREMAIL='" + email + "'";
		List<User> userList = session.createQuery(sql).list();

		if (userList.size() == 0) {
			return true;
		}

		logger.info("User email address is:" + email);
		return false;
	}
}
