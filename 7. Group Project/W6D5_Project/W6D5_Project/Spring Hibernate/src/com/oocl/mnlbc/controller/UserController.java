package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.UserSVC;
/**
 * Handles web services for User
 * 
 * @author DENOYME
 * @date 2016-07-21
 */
@RestController
public class UserController {

   private UserSVC userSVC;

   @Autowired(required = true)
   @Qualifier(value = "userService")
   public void setUserService(UserSVC us) {
      this.userSVC = us;
   }
   /**
    * getAllUsers web service
    * 
    * @return List<User>
    */
   @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
   public List<User> getAllUsers() {
      return this.userSVC.getAllUsers();
   }

   /**
    * getUserByEmail web service
    * 
    * @return List<User>
    */
   @RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
   public List<User> getUserByEmail(@RequestParam String email) {
      if (!email.isEmpty()) {
         return this.userSVC.getUserByEmail(email);
      }
      return null;
   }

   /**
    * updateUser web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
   public boolean updateUser(@RequestBody User user) {
      int result = this.userSVC.updateUser(user);
      if (user != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   /**
    * deleteUser web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
   public boolean deleteUser(@RequestParam long id) {
      int result = this.userSVC.deleteUser(id);
      if (id >= 0) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
	}
   
   @RequestMapping(value = "/updateToPremium", method = RequestMethod.POST)
   public boolean updateToPremium(@RequestParam String email) {
	   int result = this.userSVC.updateToPremium(email);
	   if(result == 1){
		   return true;
	   }
	   else{
		   return false;
	   }
	}


}
