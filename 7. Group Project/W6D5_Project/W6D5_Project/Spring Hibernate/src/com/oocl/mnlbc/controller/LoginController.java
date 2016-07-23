package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class LoginController extends HttpServlet{

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
         return false;
      return this.userSVC.validateUser(email, password);
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
   
   @RequestMapping(value = "/logout")
   public void logoutSystem(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   HttpSession session = request.getSession();
	   session.invalidate();
   }
}
