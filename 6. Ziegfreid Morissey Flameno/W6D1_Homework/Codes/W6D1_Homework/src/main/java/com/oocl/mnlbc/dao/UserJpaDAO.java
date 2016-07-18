package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.entity.User;

public interface UserJpaDAO extends AbstractJpaDAO<User> {

   /**
    * Returns an User object that matches the id given
    *
    * @param userId
    * @return
    */
   public User loadUserByUserId(String userId);
}