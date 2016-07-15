package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.model.User;

public interface UserSVC {
	public boolean validateUser(String email);
	public User getUser(String email, String password);
	public int createUser(User user);
	public int deleteUser(User user);
	public int updateUserType(User user,String type);
	public List<Long> getBlackList();
   public User getUserByEmail(String email);
}
