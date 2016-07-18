package com.oocl.mnlbc.test;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.service.UserService;

import junit.framework.TestCase;

public class Number2Test extends TestCase {

   public void testGetUserInfo() {
      UserService us = new UserService();
      us.init();
      EntityManager em = us.getEntityManager();
      String id = "1";
      assertNotNull(us.getUserInfo(em, id));
   }
   
   public void testGetUserOrderInfo() {
      UserService us = new UserService();
      us.init();
      EntityManager em = us.getEntityManager();
      String id = "1";
      assertNotNull(us.getUserOrderInfo(em, id));
   }
   
   public void testGetUserOrderItemInfo() {
      UserService us = new UserService();
      us.init();
      EntityManager em = us.getEntityManager();
      String id = "1";
      assertNotNull(us.getUserOrderItemsInfo(em, id));
   }

}
