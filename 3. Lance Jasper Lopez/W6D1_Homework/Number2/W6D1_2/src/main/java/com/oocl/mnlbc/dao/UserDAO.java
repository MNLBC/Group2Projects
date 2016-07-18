package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.model.User;

public interface UserDAO extends GenericDAO<User> {

	public User loadUser(String username);
}