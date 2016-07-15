package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.dao.UserDAOImpl;

public class UserDAOImplTest {
	UserDAOImpl userDAO = new UserDAOImpl();
	User testUser = new User(9999,"test","test","test","test","test","test","test","Cutomer");
	

	@Test
	public void testValidateUser() {
		assertTrue(userDAO.validateUser("itsmelexi@yp.com"));
	}

	@Test
	public void testGetUser() {
		User user = userDAO.getUser("itsmelexi@yp.com", "abc");
		assert(user!=null);
	}

	@Test
	public void testCreateUser() {
		int result = userDAO.createUser(testUser);
		assert(result > 0);
	}

	@Test
	public void testUpdateUserType() {
		int result = userDAO.updateUserType(userDAO.getUser("test", "test"),"BLACKLIST");
		assert(result > 0);
	}

	@Test
	public void testGetBlackList() {
		List<Long> id = userDAO.getBlackList();
		assert(id!=null);
	}

	@Test
	public void testDeleteUser() {
		int result = userDAO.deleteUser(userDAO.getUser("test", "test"));
		assert(result > 0);
	}

}
