package com.oocl.mnlbc.testing;

import com.oocl.mnlbc.service.RegistrationService;

import junit.framework.TestCase;

public class RegistrationServiceTest extends TestCase {
	RegistrationService rs = new RegistrationService();

	public void testTestingRegistration() {
		boolean testingRegister = rs.testingRegistration("Danna", "Danna12", "Danna Pauline", "Soquiat",
				"09267903241", "danna.soquiat@gmail.com");
		assertTrue(testingRegister);
	}

	public void testingPasswords() {
		boolean testingPasswords = rs.testingPasswords("danna", "danna");
		assertTrue(testingPasswords);
	}
}