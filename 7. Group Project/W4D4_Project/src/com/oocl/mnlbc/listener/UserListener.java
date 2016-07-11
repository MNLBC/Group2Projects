package com.oocl.mnlbc.listener;

import java.util.List;

import javax.servlet.ServletContext;
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
        ServletContext ctx = session.getServletContext();
        Integer ctr = (Integer) ctx.getAttribute("ctr");
        if (ctr == null) {
           ctr = new Integer(1);
        } else {
           ctr = new Integer(ctr + 1);
        }
        ctx.setAttribute("ctr", ctr);
        //session.setMaxInactiveInterval(60);
        System.out.println("Session Created:: ID=" + event.getSession().getId());
        System.out.println("User Count: " + ctr);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  {
    	HttpSession session = event.getSession();
        ServletContext ctx = session.getServletContext();
        Integer ctr = (Integer) ctx.getAttribute("ctr");
        if (ctr != null && ctr != 0) {
           ctr = new Integer(ctr - 1);
        }
        ctx.setAttribute("ctr", ctr);
        session.setMaxInactiveInterval(60);
        System.out.println("Session Destroyed:: ID=" + event.getSession().getId());
    }
	
}
