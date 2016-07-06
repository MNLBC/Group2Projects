package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   UserDao dao = new UserDaoImpl();
		
	   User usr = dao.getUserById(request.getParameter("id"));
		request.setAttribute("usr", usr);
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/views/edit_usrloyee.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   UserDao dao = new UserDaoImpl();
	   User usr = new User();
		usr.setId(request.getParameter("usr_id"));
		usr.setFirstName(request.getParameter("first_name"));
		usr.setLastName(request.getParameter("last_name"));
		usr.setAddress(request.getParameter("address"));
		usr.setEmail(request.getParameter("email"));
		usr.setUserName(request.getParameter("username"));
		usr.setPassword(request.getParameter("password"));
		
		dao.updateUser(usr);
		response.sendRedirect("ShowUser?editsuccess=true");
	}

}
