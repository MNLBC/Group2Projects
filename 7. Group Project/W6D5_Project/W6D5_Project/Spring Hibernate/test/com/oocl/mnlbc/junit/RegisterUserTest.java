
/**
 * JUnit package
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.model.User;

/**
 * @author Kassandra Ysabel Fuentes
 * @since 07-22-2016
 *
 */
public class RegisterUserTest {

	User user;
	String userFname = "FirstName Sample";
	String userEmail = "sample@email.com";

	/**
	 * @throws java.lang.Exception
	 *             Add user information
	 */
	@Before
	public void setUp() throws Exception {
		user = new User(001, "First Name", "Last Name", "sample@email.com", "Address 1", "Address 2", "State", 2,
				"Occupation", "City", "Country", "Password", "Type");
	}

	/**
	 * Test method for null register
	 */
	@Test
	public void testNullRegisterUser() {
		User userNew = new User();
		assertNotNull(userNew);
	}

	/**
	 * Test method for input info in register
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInfoRegisterUser() throws Exception {
		assertEquals(user.getUserEmail(), userEmail);
		assertNotSame(user.getUserFname(), userFname);
	}

}
