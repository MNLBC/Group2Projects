package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.dao.OrdersDAOImpl;
import com.oocl.mnlbc.dao.ProductDAOImpl;
import com.oocl.mnlbc.util.Timestamp;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkoutServlet")
public class CheckoutServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public CheckoutServlet() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      Order order = new Order();
      order = (Order) session.getAttribute("order");

      OrdersDAOImpl db = new OrdersDAOImpl();
      int status = db.finalOrder(order, Timestamp.getTimestamp());

      ProductDAOImpl prodDAO = new ProductDAOImpl();

      List<String[]> cartList = (List<String[]>) session.getAttribute("cartList");

      for (int i = 0; i < cartList.size(); i++) {
         prodDAO.updateStock(cartList.get(i));
      }

      String msg = "";
      if (status == 1)
         msg = "success";
      else
         msg = "failed";

      request.setAttribute("status", msg);
      RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
      rd.forward(request, response);

      // response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
   }

}
