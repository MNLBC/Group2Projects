package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

      PrintWriter out = response.getWriter();

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
      user.setUserFname(fname);
      user.setUserLname(lname);
      user.setUserEmail(email);
      user.setUserStreet(street);
      user.setUserCity(city);
      user.setUserCountry(country);
      user.setUserPassword(password);
      user.setUserType(type);

      if (!dao.validateUser(email)) {
         out.println("<script type=\"text/javascript\">");
         out.println("alert('User already registered');");
         out.println("</script>");
         out.println("<a href='AddUser'>Register</a>"); // if email is already in db
      } else {
         dao.createUser(usr);
         response.sendRedirect("ShowUser?addsuccess=true"); // if registration successful
      }

      if(msg=="success"){
         response.sendRedirect("ShowUser?addsuccess=true"); // if registration successful
      }
   }

}
