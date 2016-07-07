package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.bean.User;

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
      String fname = request.getParameter("fname");
      String lname = request.getParameter("lname");
      String email = request.getParameter("email");
      String street = request.getParameter("street");
      String city = request.getParameter("city");
      String country = request.getParameter("country");
      String password = request.getParameter("password");
      String type = request.getParameter("type");
      User user = new User();
      String msg = "failed";
      if (fname != null && lname != null && email != null && street != null && city != null && country != null
         && password != null && type != null) {
         user.setFname(fname);
         user.setLname(lname);
         user.setEmail(email);
         user.setStreet(street);
         user.setCity(city);
         user.setCountry(country);
         user.setPassword(password);
         user.setType(type);
         user.setPassword(password);
         // if (!DbTransact.checkExisting(user)) {
         // int result = DbTransact.createUser(user);
         // if (result != 0) {
         // msg = "success";
         // }
         // }
      }
      response.getWriter().append(msg);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
