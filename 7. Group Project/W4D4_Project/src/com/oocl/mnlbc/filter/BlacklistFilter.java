package com.oocl.mnlbc.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		List<Long> blacklist = userDAO.getBlackList();
		String userEmail = req.getParameter("userEmail");
		String userPass = req.getParameter("userPass");
		User user = userDAO.getUser(userEmail, userPass);
		if(blacklist.contains(user.getUserId())){
			showWarning(response, req);	
		}
		else{
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	  private void showWarning(ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletContext sc = req.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/Errors.jsp"); // edit here
      rd.forward(req, response);
		
	  }
	}
