package com.oocl.mnlbc.listener;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.UserDAOImpl;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class UserListener implements HttpSessionListener {
	UserDAOImpl userDAO = new UserDAOImpl();

    /**
     * Default constructor. 
     */
    public UserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
    	HttpSession session = event.getSession();
    	session.setMaxInactiveInterval(100);
    	User user = (User) session.getAttribute("user");
        userDAO.setActive(user);
        List<User> userList = userDAO.getActiveUser();
        int userCount = userList.size();
        
        
    	session.setAttribute("userCount", userCount);
    	System.out.println("Total : " + userCount);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  {
    	HttpSession session = event.getSession();
    	User user = (User) session.getAttribute("user");
        userDAO.setInactive(user);
        List<User> userList = userDAO.getActiveUser();
        int userCount = userList.size();
        
        
    	session.setAttribute("userCount", userCount);
    	System.out.println("Total : " + userCount);
    }
	
}
