package com.oocl.mnlbc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.OnlineUserDAO;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.OnlineUser;


/**
 * JPA DAO Implementation for OnlineUsers TABLE
 * 
 * @author DENOYME
 * @since 2016-07-27
 */
@Repository
@Transactional
public class OnlineUserDAOImpl implements OnlineUserDAO {

   private static final Logger logger = LoggerFactory.getLogger(CartProductDAOImpl.class);

   @PersistenceContext
   private EntityManager manager;

   @Override
   public int addOnlineUser(OnlineUser onluser) {
      manager.persist(onluser);
      logger.info("OnlineUser saved successfully, onlineuser details=" + onluser);
      return 1;
   }

   @Override
   public List<OnlineUser> getAllOnlineUser() {
      String sql = "SELECT onlineuser FROM OnlineUser onlineuser";
      List<OnlineUser> onlineuserlist = manager.createQuery(sql).getResultList();
      for (OnlineUser onlineuser : onlineuserlist) {
         logger.info("OnlineUser list =" + onlineuser);
      }
      return onlineuserlist;
   }

   @Override
   public int deleteOnlineUser(String email) {
      String sql = "SELECT onlineuser FROM OnlineUser onlineuser WHERE onlineuser.userEmail = '" + email + "'";
      List<OnlineUser> deletedonlineuser = manager.createQuery(sql).getResultList();
      logger.info("User email = " + email);
      for (OnlineUser onlineuser : deletedonlineuser) {
         manager.remove(onlineuser);
         logger.info("OnlineUser deleted successfully!=" + onlineuser);
      }
      return 1;
   }
}
