package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.OnlineUser;
import com.oocl.mnlbc.svc.inf.OnlineUserSVC;
import com.oocl.mnlbc.util.Timestamp;

/**
 * Handles web services for Online Users
 * 
 * @author DENOYME
 * @since 2016-07-27
 */
@RestController
public class OnlineUserController {

   private OnlineUserSVC onlineUserSVC;

   @Autowired(required = true)
   @Qualifier(value = "onlineUserService")
   public void setOnlineUserService(OnlineUserSVC onlineUserSVC) {
      this.onlineUserSVC = onlineUserSVC;
   }

   /**
    * getAllOnline web service
    * 
    * @return List<OnlineUser>
    */
   @RequestMapping(value = "/getAllOnline", method = RequestMethod.GET)
   public List<OnlineUser> getAllOnlineUsers() {
      return this.onlineUserSVC.getAllOnlineUser();
   }
}
