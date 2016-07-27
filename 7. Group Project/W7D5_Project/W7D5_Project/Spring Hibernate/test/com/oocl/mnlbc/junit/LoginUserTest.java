/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;

/**
 * @author Kassandra Ysabel Fuentes
 * @since 07-22-2016
 */
public class LoginUserTest {

	User user;
	private static final String userEmail1 = "myEmail@domain.com";
	private static final String userPass1 = "password001";
	private static final String userEmail2 = "sample@email.com";
	private static final String userPass2 = "Password";
	private static final String blacklist = "Blacklist";

	/**
	 * @throws java.lang.Exception
	 *             Add user information
	 */
	@Before
	public void setUp() throws Exception {
		user = new User(001, "First Name", "Last Name", "sample@email.com", "Address 1", "Address 2", "State", 2,
				"Occupation", "City", "Country", "Password", "Blacklist");
	}

	/**
	 * Test method for login incorrect
	 */
	@Test
	public void testIncorrectLoginUser() {
		assertNotSame(user.getUserEmail(), userEmail1);
		assertNotSame(user.getUserPass(), userPass1);
	}
	
	/**
	 * Test method for login correct
	 */
	@Test
	public void testCorrectLoginUser() {
		assertSame(user.getUserEmail(), userEmail2);
		assertSame(user.getUserPass(), userPass2);
	}

	/**
	 * Test method for Blacklist
	 */
	@Test
	public void testGetBlackList() {
		String type = user.getUserType();
		boolean check = false;
		switch(type)
		{
		case "Admin":
			check = false;
			break;
		case "Blacklist":
			check = true;
			break;
		default:
			check = false;
		}
		assertTrue(check);
	}
}
