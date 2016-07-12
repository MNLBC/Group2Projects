package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.controller.WelcomeController;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.validator.UserValidator;

public class UserValidatorTest {

	@Test
	public void testSupports() {
		UserValidator uv = new UserValidator();
		assertTrue(uv.supports(User.class));
		assertFalse(uv.supports(WelcomeController.class));
	}

}
