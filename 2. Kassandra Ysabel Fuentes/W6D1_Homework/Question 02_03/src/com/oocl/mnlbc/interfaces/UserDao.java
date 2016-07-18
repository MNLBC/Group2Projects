package com.oocl.mnlbc.interfaces;

public interface UserDao extends GenericDao<User> {
   
    public User loadUserByUsername(String username);
}