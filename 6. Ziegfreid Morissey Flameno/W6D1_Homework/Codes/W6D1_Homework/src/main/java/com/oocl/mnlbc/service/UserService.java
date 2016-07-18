package com.oocl.mnlbc.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.dao.UserJpaDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
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
   
   @Autowired
   private UserJpaDAO dao;

   public void getUserInfoByDAO(String userId) {
       User u = dao.loadUserByUserId("1");
       System.out.println(u);
   }
   
   public User getUserInfo(EntityManager em, String id) {
      User user = em.find(User.class, id);
      return user;
   }
   
   public List<Order> getUserOrderInfo(EntityManager em, String id) {
      User user = em.find(User.class, id);
      return user.getOrderList();
   }
   
   public List<OrderItem> getUserOrderItemsInfo(EntityManager em, String id) {
      User user = em.find(User.class, id);
      List<OrderItem> orderItems = new ArrayList<OrderItem>();
      for(Order order : user.getOrderList()){
         orderItems.addAll(order.getOrderItemList());
      }
      return orderItems;
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }
}
