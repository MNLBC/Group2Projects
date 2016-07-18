package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.entity.User;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component("userDao")
public class UserJpaDAOImpl extends AbstractJpaDAOImpl<User> implements UserJpaDAO {

   public User loadUserByUserId(String userId) {
      Query query = this.em.createQuery("select u FROM Users u where u.user_id= :user_id");
      query.setParameter("user_id", userId);
      List<User> users = query.getResultList();
      if (users != null && users.size() == 1) {
         return users.get(0);
      }
      return null;
   }
}