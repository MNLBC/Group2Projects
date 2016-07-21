package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.User;

public interface UserDAO {
	public List<User> getAllUser(long userId, String userFname, String userLname, String userEmail,String userAddress1, String userAddress2, String userSp, int userLevel,String userOccup);
	public boolean validateUser(String email);
	public User getUser(String email, String password);
	public int createUser(User user);  
	public List<User> getUserByEmail(String email);
	public List<User> getUserBlackList();
	public List<User> getPremiumUser();
    public int updateUser(User user);
	public int deleteUser(long id);
}
