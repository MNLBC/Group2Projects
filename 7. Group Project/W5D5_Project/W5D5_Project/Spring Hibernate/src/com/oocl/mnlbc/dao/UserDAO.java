package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.model.User;

public interface UserDAO {
	public boolean validateUser(String email);
	public User getUser(String email, String password);
	public int createUser(User user);  
	public List<User> getUserByEmail(String email);
	public List<User> getUserBlackList();
    public int updateUser(User user);
	public int deleteUser(long id);
}
