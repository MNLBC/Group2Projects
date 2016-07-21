package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;

/**
 * Handles web services for Login
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
@ResponseBody
public class LoginController {

   private UserSVC userSVC;

   @Autowired(required = true)
   @Qualifier(value = "userService")
   public void setUserService(UserSVC userSVC) {
      this.userSVC = userSVC;
   }
   
   /**
    * Login web service
    * 
    * @param email
    * @param password
    * @return boolean
    */
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public boolean loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
      if(email.isEmpty() && password.isEmpty())
         return this.userSVC.validateUser(email);
      return false;
   }

   /**
    * getBlackList web service
    * 
    * @return List<User>
    */
   @RequestMapping(value = "/getBlacklist", method = RequestMethod.GET)
   public List<User> getBlackList() {
      return this.userSVC.getBlackList();
   }
}
