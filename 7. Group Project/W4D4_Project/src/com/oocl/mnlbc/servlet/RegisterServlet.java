package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
      String msg = "failed";
      String userFname = request.getParameter("userFname");
      String userLname = request.getParameter("userLname");
      String userEmail = request.getParameter("userEmail");
      String userStreet = request.getParameter("userStreet");
      String userCity = request.getParameter("userCity");
      String userCountry = request.getParameter("userCountry");
      String userPass = request.getParameter("userPass");
      String userType = request.getParameter("userType");
      if (userFname != null && userLname != null && userEmail != null && userStreet != null && userCity != null
         && userCountry != null && userPass != null && userType != null) {
         user.setUserFname(userFname);
         user.setUserLname(userLname);
         user.setUserEmail(userEmail);
         user.setUserStreet(userStreet);
         user.setUserCity(userCity);
         user.setUserCountry(userCountry);
         user.setUserPass(userPass);
         user.setUserType(userType);
         if (!dao.validateUser(user.getUserEmail())) {
            int result = dao.createUser(user);
            if (result != 0) {
               msg = "success";
            }
         }
      }
      response.getWriter().append(msg);
      if(msg=="success"){
    	  ServletContext sc = this.getServletContext();
     	 RequestDispatcher rd = sc.getRequestDispatcher("/views/edit_user.jsp"); // edit here
     	 rd.forward(request, response);
      }
   }

}
