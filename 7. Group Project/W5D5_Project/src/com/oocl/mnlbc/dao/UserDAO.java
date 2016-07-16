package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.model.User;

public interface UserDAO {
	public boolean validateUser(String email);
	public User getUser(String email, String password);
	public void createUser(User user);  
	public List<User> getUserByEmail(String email);
	List<User> getUserBlackList(User user);
    void updateUser(User user);
	void deleteUser(int id);
}
