package com.oocl.mnlbc.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.UserDAOImpl;

/**
 * Servlet Filter implementation class BlacklistFilter
 */
@WebFilter("/BlacklistFilter")
public class BlacklistFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BlacklistFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		UserDAOImpl userDAO = new UserDAOImpl();
		List<User> blacklist = userDAO.getBlackList();
		User user = (User) req.getAttribute("user");

		if(blacklist.contains(user)){
			showWarning(response);
		}
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	  private void showWarning(ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType =
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		"Transitional//EN\">\n";
		out.println
		(docType +
		"<HTML>\n" +
		"<HEAD><TITLE>Access Prohibited</TITLE></HEAD>\n" +
		"<BODY BGCOLOR=\"WHITE\">\n" +
		"<H1>Access Prohibited</H1>\n" +
		"Sorry, you are not authorized" +
		"</BODY></HTML>");
	  }
	}
