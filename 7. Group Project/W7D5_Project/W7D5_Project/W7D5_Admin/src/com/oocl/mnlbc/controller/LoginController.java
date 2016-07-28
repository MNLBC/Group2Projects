package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.OnlineUser;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.OnlineUserSVC;
import com.oocl.mnlbc.svc.inf.UserSVC;
import com.oocl.mnlbc.util.Timestamp;

/**
 * Handles web services for Login
 * 
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
public class LoginController extends HttpServlet {

   private UserSVC userSVC;
   private OnlineUserSVC onlineUserSVC;

   @Autowired(required = true)
   @Qualifier(value = "userService")
   public void setUserService(UserSVC userSVC) {
      this.userSVC = userSVC;
   }

   @Autowired(required = true)
   @Qualifier(value = "onlineUserService")
   public void setOnlineUserService(OnlineUserSVC onlineUserSVC) {
      this.onlineUserSVC = onlineUserSVC;
   }

   /**
    * Login web service
    * 
    * @param email
    * @param password
    * @return boolean
    */
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public boolean loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
      HttpServletRequest request) {
      if (email.isEmpty() && password.isEmpty())
         return false;
      boolean result = this.userSVC.validateUser(email, password);
      if (result) {
         OnlineUser onluser = new OnlineUser();
         onluser.setUserEmail(email);
         onluser.setOnlineDate(Timestamp.getTimestamp());
         this.onlineUserSVC.addOnlineUser(onluser);
         HttpSession session = request.getSession();
         session.setAttribute("useremail", email);
      }
      return result;
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

   /**
    * logout web service
    * 
    * @param request
    * @param response
    */
   @RequestMapping(value = "/logout", method = RequestMethod.POST)
   public boolean logoutSystem(HttpServletRequest request, HttpServletResponse response) {
      try {
         HttpSession session = request.getSession();
         session.invalidate();
         return true;
      } catch (Exception e) {
         return false;
      }
   }
}
