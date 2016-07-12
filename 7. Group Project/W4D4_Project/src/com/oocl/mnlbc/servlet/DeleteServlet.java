package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.OrderProduct;
import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.OrderProductDAOImpl;
import com.oocl.mnlbc.dao.OrdersDAOImpl;
import com.oocl.mnlbc.dao.UserDAOImpl;

/**
 * 
 * @author Kassandra Fuentes
 * 
 *         Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public DeleteServlet() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(true);
      String action = (String) request.getAttribute("action");
      String lastURL = (String) request.getAttribute("lastURL");
      int result = 0;
      String msg = "";

      if (action.equals("deleteuser")) {
         UserDAOImpl userDao = new UserDAOImpl();
         User user = (User) request.getAttribute("user");
         result = userDao.deleteUser(user);
      } else if (action.equals("deleteorder")) {
         OrdersDAOImpl orderDao = new OrdersDAOImpl();
         Order order = (Order) request.getAttribute("order");
         result = orderDao.cancelOrder(order);
      } else if (action.equals("deleteproduct")) {
         OrderProductDAOImpl orderProductDao = new OrderProductDAOImpl();
         long orderProduct = Long.parseLong(request.getParameter("orderProdId"));
         // result = orderProductDao.removeProduct(orderProduct);
      }
      if (result == 1)
         msg = "success";
      else
         msg = "failed";

      request.setAttribute("status", msg);
      RequestDispatcher rd = request.getRequestDispatcher(lastURL); // something.jsp
      rd.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
   }

}
