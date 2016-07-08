package com.oocl.mnlbc.dao;

import java.sql.Connection;

import com.oocl.mnlbc.bean.User;

public interface UserDAO {
	public boolean validateUser(String email);
	public User getUser(String email, String password);
	public int createUser(User user);
	public int setActive(User user);
	public int setInactive(User user);
	public int updateUser(User user);
}
