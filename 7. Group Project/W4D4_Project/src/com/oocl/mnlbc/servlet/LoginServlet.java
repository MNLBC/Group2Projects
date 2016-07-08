package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.dao.UserDAOImpl;

/**
 * @author Kassandra Fuentes
 * 
 *         Servlet implementation class LoginServlet
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public LoginServlet() {
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

      try {

         UserDAO dao = new UserDAOImpl();
         User user = new User();
         PrintWriter out = response.getWriter();
         String userEmail = request.getParameter("userEmail");
         String userPassword = request.getParameter("userPassword");
         user.setUserEmail(userEmail);
         user.setUserPassword(userPassword);
         HttpSession session = request.getSession(true);
         session.setAttribute("username", userEmail);

         if (dao.getUser(userEmail, userPassword) != null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Wrong username/password');");
            out.println("</script>");
            out.println("<a href='index.jsp'>Login</a>"); // if email/password does not match
         } else {
            response.sendRedirect("ShowUser"); // if login successful
         }

      } catch (Throwable theException) {
         System.out.println(theException);
      }
   }
}
