package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.oocl.mnlbc.service.RegisterService;

public class RegisterServiceTest {
	RegisterService rs = new RegisterService();
	@Test
	public void testTestingRegistrationSuccess() {
		boolean testingRegister = rs.testingRegistration("Meynard", "Denoyo", "denoyme", "1234");
		assertTrue(testingRegister);
		
	}

}
