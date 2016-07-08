package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.UserDao;
import com.oocl.mnlbc.dao.UserDaoImpl;
import com.oocl.mnlbc.utils.UserDAO;
import com.oocl.mnlbc.utils.UserDAOImpl;

/**
 * 
 * @author Kassandra Fuentes
 * 
 *         Servlet implementation class RegisterServlet
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
      doPost(request, response);

   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      UserDAO dao = new UserDAOImpl();
      User usr = new User();
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
         user.setUserFname(fname);
         user.setUserLname(lname);
         user.setUserEmail(email);
         user.setUserStreet(street);
         user.setUserCity(city);
         user.setUserCountry(country);
         user.setUserPassword(password);
         user.setUserType(type);
         user.setUserPassword(password);
         // if (!DbTransact.checkExisting(user)) {
         // int result = DbTransact.createUser(user);
         // if (result != 0) {
         // msg = "success";
         // }
         // }
      }
      response.getWriter().append(msg);
   }

}
