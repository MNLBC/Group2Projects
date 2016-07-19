package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.User;

/**
 * User Service to get user info
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
public class UserService {

   private EntityManagerFactory entityManagerFactory;
   private EntityManager entityManager;

   @SuppressWarnings("rawtypes")
   public void init() {
      entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
      System.out.println(entityManagerFactory.getClass().getSimpleName());
      entityManager = entityManagerFactory.createEntityManager();
      System.out.println(entityManager.getClass().getSimpleName());

   }

   public User getUserInfo(EntityManager em, String id) {
      User user = em.find(User.class, id);
      return user;
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }
}
