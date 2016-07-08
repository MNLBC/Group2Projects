package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.dao.UserDAOImpl;

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
      User user = new User();
      String userFname = request.getParameter("userFname");
      String userLname = request.getParameter("userLname");
      String userEmail = request.getParameter("userEmail");
      String userStreet = request.getParameter("userStreet");
      String userCity = request.getParameter("userCity");
      String userCountry = request.getParameter("userCountry");
      String userPassword = request.getParameter("userPassword");
      String userType = request.getParameter("userType");
      String msg = "failed";
      if (userFname != null && userLname != null && userEmail != null && userStreet != null && userCity != null
         && userCountry != null && userPassword != null && userType != null) {
         user.setUserFname(userFname);
         user.setUserLname(userLname);
         user.setUserEmail(userEmail);
         user.setUserStreet(userStreet);
         user.setUserCity(userCity);
         user.setUserCountry(userCountry);
         user.setUserPassword(userPassword);
         user.setUserType(userType);
         if (!dao.validateUser(user.getUserEmail())) {
            int result = dao.createUser(user);
            if (result != 0) {
               msg = "success";
            }
         }
      }
      response.getWriter().append(msg);
   }

}
