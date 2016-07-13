package com.oocl.mnlbc.service;

public class RegistrationService {

	public boolean testingRegistration(String userName, String password, String firstName, String lastName,
			String contactNumber, String email) {
		return (userName != "" && password != "" && firstName != "" && lastName != "" && contactNumber != ""
				&& email != "");
	}

	public boolean testingPasswords(String password, String confirmPassword) {
		return password == confirmPassword;
	}

}