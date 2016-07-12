/**
 * 
 */
package com.oocl.mnlbc.junit;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.service.UserValidator;

import junit.framework.TestCase;

/**
 * JUNIT Test for User Validator
 * @author FLAMEZI2
 * @since 2016-07-12
 */
public class UserValidatorTest extends TestCase {

	/**
	 * Test method for {@link com.oocl.mnlbc.service.UserValidator#supports(java.lang.Class)}.
	 */
	public void testSupportsUser() {
		UserValidator userValidator = new UserValidator();
		assertTrue(userValidator.supports(User.class));
	}
	
	public void testSupportsString() {
		UserValidator userValidator = new UserValidator();
		assertFalse(userValidator.supports(String.class));
	}

}
