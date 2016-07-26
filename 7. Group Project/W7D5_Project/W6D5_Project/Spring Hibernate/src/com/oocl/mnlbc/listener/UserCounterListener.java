package com.oocl.mnlbc.listener;


import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oocl.mnlbc.dao.impl.UserDAOImpl;;

/**
 * @author SOQUIDA
 * @since 2016-07-21
 */
@WebListener
public class UserCounterListener implements HttpSessionListener {

   UserDAOImpl userDAO = new UserDAOImpl();
   private static final Logger logger = LoggerFactory.getLogger(UserCounterListener.class);
   /**
    * Default constructor.
    */
   public UserCounterListener() {
   }

   /**
    * 
    * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
    */
   public void sessionCreated(HttpSessionEvent event) {
      HttpSession session = event.getSession();
      ServletContext ctx = session.getServletContext();
      Integer ctr = (Integer) ctx.getAttribute("ctr");
      if (ctr == null) {
         ctr = new Integer(1);
      } else {
         ctr = new Integer(ctr + 1);
      }
      ctx.setAttribute("ctr", ctr);
      // session.setMaxInactiveInterval(60);
      logger.info("Session Created:: ID=" + event.getSession().getId());
      logger.info("User Count: " + ctr);
   
    
   }

   /**
    * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
    */
   public void sessionDestroyed(HttpSessionEvent event) {
      HttpSession session = event.getSession();
      ServletContext ctx = session.getServletContext();
      Integer ctr = (Integer) ctx.getAttribute("ctr");
      if (ctr != null && ctr != 0) {
         ctr = new Integer(ctr - 1);
      }
      ctx.setAttribute("ctr", ctr);
      session.setMaxInactiveInterval(60);
      logger.info("Session Destroyed:: ID=" + event.getSession().getId());
   }

}
