package com.oocl.mnlbc.servlet;
import com.oocl.mnlbc.utils.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	   PrintWriter out = response.getWriter();
	   String firstname, lastname, email, username, password;
	   firstname = request.getParameter("fname");
	   lastname = request.getParameter("lname");
	   email = request.getParameter("email");
	   username = request.getParameter("uname");
	   password = request.getParameter("pword");
	   
	   if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()){
	      request.setAttribute("type", "fieldsempty");
         RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
         rd.forward(request, response);
	   }else{
	      if(!DBConnection.checkUser(username)){
	         DBConnection.registerUser(firstname, lastname, email, username, password);
	         out.print("<!DOCTYPE html>"
	            + "<html>"
	            + "<head><title>Three Parameters</title></head>"
	            + "<body>"
	            + "User information successfully saved!<br>"
	            + "First Name: " + request.getParameter("fname") + "<br>"
	            + "Last Name: " + request.getParameter("lname") + "<br>"
	            + "Email: " + request.getParameter("email") + "<br>"
	            + "Username: " + request.getParameter("uname") + "<br>"
	            + "Password: " + request.getParameter("pword") + "<br>"
	            + "</body></html>");
	      }else{
//	       out.print("<script>alert('User already exists')</script>");
	         request.setAttribute("type", "userexist");
	         request.setAttribute("user", username);
	         RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	         rd.forward(request, response);
	         //rd.include(request, response);
	      }
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
