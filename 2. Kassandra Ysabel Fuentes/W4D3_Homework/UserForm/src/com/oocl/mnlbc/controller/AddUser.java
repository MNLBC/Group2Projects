package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.UserDao;
import com.oocl.mnlbc.dao.UserDaoImpl;
import com.oocl.mnlbc.model.User;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/views/add_user.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   UserDao dao = new UserDaoImpl();
	   User usr = new User();
	   String uname = null;
	   String email = null;
	   PrintWriter out = response.getWriter();
		usr.setId(request.getParameter("usr_id"));
		usr.setFirstName(request.getParameter("first_name"));
		usr.setLastName(request.getParameter("last_name"));
		usr.setAddress(request.getParameter("address"));
		usr.setEmail(request.getParameter("email"));
		usr.setUserName(request.getParameter("username"));
		usr.setPassword(request.getParameter("password"));
		uname = request.getParameter("username");
		email = request.getParameter("email");
		
		 if(!dao.validateUser(uname, email))
       {
          out.println("<script type=\"text/javascript\">");
          out.println("alert('User already registered');");
          out.println("</script>");
          out.println("<a href='AddUser'>Register</a>");
       }
       else{
          dao.addUser(usr);
          response.sendRedirect("ShowUser?addsuccess=true");      
       }
		
		
	}

}
