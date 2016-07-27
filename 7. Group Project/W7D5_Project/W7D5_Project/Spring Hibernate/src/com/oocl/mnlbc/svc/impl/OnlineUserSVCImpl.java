package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.CartProductDAO;
import com.oocl.mnlbc.dao.inf.OnlineUserDAO;
import com.oocl.mnlbc.model.OnlineUser;
import com.oocl.mnlbc.svc.inf.OnlineUserSVC;

/**
 * SVC Implementation for OnlineUsers Table
 * 
 * @author DENOYME
 * @since 2016-07-27
 */
public class OnlineUserSVCImpl implements OnlineUserSVC {

   private OnlineUserDAO onlineUserDAO;

   public void setOnlineUserDAO(OnlineUserDAO onlineUserDAO) {
      this.onlineUserDAO = onlineUserDAO;
   }

   @Override
   @Transactional
   public int addOnlineUser(OnlineUser onluser) {
      return this.onlineUserDAO.addOnlineUser(onluser);
   }

   @Override
   @Transactional
   public List<OnlineUser> getAllOnlineUser() {
      return this.onlineUserDAO.getAllOnlineUser();
   }

   @Override
   @Transactional
   public int deleteOnlineUser(String email) {
      return this.onlineUserDAO.deleteOnlineUser(email);
   }

}
