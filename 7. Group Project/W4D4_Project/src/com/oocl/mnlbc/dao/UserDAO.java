package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.util.List;

import com.oocl.mnlbc.bean.User;

public interface UserDAO {
	public boolean validateUser(String email);
	public User getUser(String email, String password);
	public int createUser(User user);
	public int deleteUser(User user);
	public int setActive(User user);
	public int setInactive(User user);
	public int updateUserType(User user,String type);
	public List<User> getActiveUser();
	public List<User> getBlackList();
}
