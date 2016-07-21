package com.oocl.mnlbc.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.impl.TempUserDAOImpl;
import com.oocl.mnlbc.model.User;

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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String userEmail = req.getParameter("email");
		
		List<User> blacklist = new ArrayList<User>();
		TempUserDAOImpl tempDAO = new TempUserDAOImpl();
		tempDAO.init();
		EntityManager em = tempDAO.getEntityManager();
		blacklist = tempDAO.getBlacklist(em);
		boolean blacklisted = false;
		
		for(int i = 0; i < blacklist.size(); i++){
			if(blacklist.get(i).getUserEmail().equals(userEmail)){
				blacklisted = true;
			}
		}
		
		if(blacklisted == false){
			chain.doFilter(request, response);
		} else{
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
