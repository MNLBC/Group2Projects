package com.oocl.mnlbc.dao;

public interface UserDAO {
	public void create(String username, String password, String firstName, String middleName, String lastName,
			String email, String contactNumber);
}
