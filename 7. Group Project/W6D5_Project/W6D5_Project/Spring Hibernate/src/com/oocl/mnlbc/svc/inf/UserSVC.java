package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.User;

public interface UserSVC {
	public boolean validateUser(String email, String password);

	public User getUser(String email, String password);

	public int createUser(User user);

	public int deleteUser(long id);

	// public int updateUserType(User user, String type);

	public List<User> getBlackList();

	public List<User> getUserByEmail(String email);

	public int updateUser(User user);

   public List<User> getAllUsers();
}
