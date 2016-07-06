package com.oocl.mnlbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.dao.UserDao;
import com.oocl.mnlbc.dao.UserDaoImpl;
import com.oocl.mnlbc.model.User;

@WebServlet("/LoginUser")
@SuppressWarnings("serial")

public class LoginUser extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      try {
         String username = "";
         String password = "";
         UserDao dao = new UserDaoImpl();
         User usr = new User();
         PrintWriter out = response.getWriter();
         
         usr.setUserName(request.getParameter("username"));
         usr.setPassword(request.getParameter("password"));

         username = request.getParameter("username");
         password = request.getParameter("password");

         if (dao.checkUserCredentials(username, password) == false) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Wrong username/password');");
            out.println("</script>");
            out.println("<a href='index.jsp'>Login</a>");
         }else
         {
            response.sendRedirect("ShowUser");
         }
      }

      catch (Throwable theException) {
         System.out.println(theException);
      }
   }
}
