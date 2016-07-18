package com.oocl.mnlbc.interfaces;

import com.oocl.mnlbc.entity.User;

/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

public interface UserDao extends GenericDao<User> {
   
    public User loadUserByUsername(String username);
}