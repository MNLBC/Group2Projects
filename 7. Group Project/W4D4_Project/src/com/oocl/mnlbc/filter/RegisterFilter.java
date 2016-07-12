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
import com.oocl.mnlbc.util.Config;

/**
 * Servlet Filter implementation class RegisterFilter
 */
@WebFilter("/RegisterFilter")
public class RegisterFilter implements Filter {

   /**
    * Default constructor.
    */
   public RegisterFilter() {
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
      String userFname = req.getParameter("userFname");
      String names = Config.getConfigValue("names");
      boolean valid = true;
      for (int i = 0; i < names.split(";").length; i++) {
         if (names.split(";")[i].contains(userFname)) {
            valid = false;
         }
      }
      if (valid == true) {
         chain.doFilter(request, response);
      } else {
         showWarning(response, req);
      }

   }

   /**
    * @see Filter#init(FilterConfig)
    */
   public void init(FilterConfig fConfig) throws ServletException {
   }

   private void showWarning(ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
      response.setContentType("text/html");
      ServletContext sc = req.getServletContext();
      RequestDispatcher rd = sc.getRequestDispatcher("/Errors.jsp");
      rd.forward(req, response);
   }
}
