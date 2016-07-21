package com.oocl.mnlbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;

/**
 * Handles web services for Register
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
@ResponseBody
public class RegisterController {

   private UserSVC userSVC;

   @Autowired(required = true)
   @Qualifier(value = "userService")
   public void setUserService(UserSVC userSVC) {
      this.userSVC = userSVC;
   }
   
   /**
    * Register web service
    * 
    * @param User
    * @return boolean
    */
   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public boolean registerUser(@RequestBody User user) {
      int result = this.userSVC.createUser(user);
      if (user != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }
}
