package com.oocl.mnlbc.service;

public class RegisterService {

	public boolean testingRegistration(String lastName, String firstName, String userName, String password) {
		return (firstName != "" || lastName != "" || userName != "" || password != "");
	}
}
