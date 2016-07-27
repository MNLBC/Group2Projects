package com.oocl.mnlbc.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.oocl.mnlbc.dao.impl.TempUserDAOImpl;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;

/**
 * Servlet Filter implementation class BlacklistFilter
 * @author KALINWI2
 * @since 20-JUL-2016
 */
@WebFilter("/BlacklistFilter")
public class BlacklistFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public BlacklistFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String userEmail = req.getParameter("email");

		LogUtil.logMsg(LogType.INFO, "Filtering: " + userEmail);

		List<User> blacklist = new ArrayList<User>();
		TempUserDAOImpl tempDAO = new TempUserDAOImpl();
		blacklist = tempDAO.getBlacklist();
		boolean blacklisted = false;

		for (int i = 0; i < blacklist.size(); i++) {
			if (blacklist.get(i).getUserEmail().equals(userEmail)) {
				blacklisted = true;
			}
		}

		if (blacklisted == false) {
			LogUtil.logMsg(LogType.INFO, "Filtering success");
			chain.doFilter(request, response);
		} else {
			LogUtil.logMsg(LogType.WARN, "Blacklisted: " + userEmail);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
