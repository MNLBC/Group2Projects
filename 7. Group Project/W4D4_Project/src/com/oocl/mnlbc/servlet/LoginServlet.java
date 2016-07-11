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
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.OrdersDAOImpl;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.dao.UserDAOImpl;
import com.oocl.mnlbc.util.PasswordHash;

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
         PrintWriter out = response.getWriter();
         String userEmail = request.getParameter("userEmail");
         String userPass = request.getParameter("userPass");
         HttpSession session = request.getSession(true);
         User user = dao.getUserByEmail(userEmail);

         if (user==null || user.getUserId() == 0 || !PasswordHash.validatePassword(userPass, user.getUserPass())) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Wrong username/password');");
            out.println("</script>");
            out.println("<a href='index.jsp'>Login</a>"); // if email/password does not match
         } else {
        	 session.setAttribute("user", dao.getUser(userEmail, userPass));
        	 session.setAttribute("username", userEmail);
        	 ServletContext sc = this.getServletContext();
        	 if(user.getUserType().equals("Cutomer")){
        		 RequestDispatcher rd = sc.getRequestDispatcher("/products.jsp"); // edit here
            	 rd.forward(request, response);
            	 OrdersDAOImpl orderDAO = new OrdersDAOImpl();
            	 orderDAO.createOrder(user);
        	 }
        	 else if(user.getUserType().equals("Admin")){
        		 RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp"); // edit here
            	 rd.forward(request, response);
        	 }
         }

      } catch (Throwable theException) {
         System.out.println(theException);
      }
   }
}
