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
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;
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
         ServletContext sc = this.getServletContext();
         if (user == null || user.getUserId() == 0 || !PasswordHash.validatePassword(userPass, user.getUserPass())) {
            RequestDispatcher rd = sc.getRequestDispatcher("/Errors.jsp"); // edit here
            rd.forward(request, response);
         } else {
            session.setAttribute("user", dao.getUserByEmail(userEmail));
            session.setAttribute("username", userEmail);
            LogUtil.logMsg(LogType.INFO, "Logged In: " + userEmail);
            if (user.getUserType().equals("Cutomer")) {
               RequestDispatcher rd = sc.getRequestDispatcher("/products.jsp"); // edit here
               rd.forward(request, response);
               OrdersDAOImpl orderDAO = new OrdersDAOImpl();
               orderDAO.createOrder(user);
               session.setAttribute("orderId", orderDAO.getOrderId(user).getOrderId());
               session.setAttribute("order", orderDAO.getOrderId(user));
               LogUtil.logMsg(LogType.INFO, "Create Order: " + user);
            } else if (user.getUserType().equals("Admin")) {
               RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp"); // edit here
               rd.forward(request, response);
            }
         }

      } catch (Throwable theException) {
         LogUtil.logMsg(LogType.ERROR, "Exception: " + theException);
      }
   }
}
