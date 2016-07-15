package com.oocl.mnlbc.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.model.User;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc DAO Implementation for USER TABLE
 * @date 07-15-2016
 */
public class UserSVCImpl implements UserSVC {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public boolean validateUser(String email) {
		return this.userDAO.validateUser(email);
	}

	@Override
	@Transactional
	public User getUser(String email, String password) {
		return this.userDAO.getUser(email, password);
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return this.userDAO.getUserByEmail(email);
	}

	@Override
	@Transactional
	public int createUser(User user) {
		return this.userDAO.createUser(user);
	}

	@Override
	@Transactional
	public int updateUserType(User user, String type) {
		return this.userDAO.updateUserType(user, type);
	}

	@Override
	@Transactional
	public List<Long> getBlackList() {
		return this.userDAO.getBlackList();
	}

	@Override
	@Transactional
	public int deleteUser(User user) {
		return this.userDAO.deleteUser(user);
	}
}