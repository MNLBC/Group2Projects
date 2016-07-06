package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.model.User;

public interface UserDao {

	public List<User> getAllUser();
	public User getUserById(String id);
	public void addUser(User data);
	public void updateUser(User data);
	public void deleteUser(String id);
	public boolean validateUser(String email, String username);
	public boolean checkUserCredentials(String username, String password);
	
}
