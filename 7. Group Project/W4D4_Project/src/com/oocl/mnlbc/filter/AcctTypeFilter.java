package com.oocl.mnlbc.filter;

import java.io.IOException;
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
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.UserDAOImpl;

/**
 * Servlet Filter implementation class AcctTypeFilter
 */
@WebFilter("/AcctTypeFilter")
public class AcctTypeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AcctTypeFilter() {
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
		HttpServletResponse res = (HttpServletResponse)response;
		UserDAOImpl userDAO = new UserDAOImpl();
		List<Long> blacklist = userDAO.getBlackList();
		String userEmail = req.getParameter("userEmail");
		String userPass = req.getParameter("userPass");
		User user = userDAO.getUser(userEmail, userPass);
		
		if(user.getUserType().equals("Cutomer")){
			// redirect to Customer page
			RequestDispatcher rd = req.getRequestDispatcher("products.html"); //something.jsp
		      rd.forward(req,res);
		}
		else{
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
