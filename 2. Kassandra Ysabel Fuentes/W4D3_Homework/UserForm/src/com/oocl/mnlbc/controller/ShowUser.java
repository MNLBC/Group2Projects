package com.oocl.mnlbc.controller;

import java.io.IOException;
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
 * Servlet implementation class ShowUser
 */
@WebServlet("/ShowUser")
public class ShowUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   UserDao dao = new UserDaoImpl();
		
		List<User> usr = dao.getAllUser();
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/views/view_user.jsp");
		request.setAttribute("usr", usr);
		
		rd.forward(request, response);
	}


}
