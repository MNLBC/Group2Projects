package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.dao.OrdersDAOImpl;
import com.oocl.mnlbc.dao.ProductDAOImpl;
import com.oocl.mnlbc.util.Timestamp;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public CheckoutServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Order order = new Order();
      order = (Order) request.getAttribute("order");
	  
	  OrdersDAOImpl db = new OrdersDAOImpl();
      int status = db.finalOrder(order,Timestamp.getTimestamp());
      
      ProductDAOImpl prodDAO = new ProductDAOImpl();
      //int status2 = prodDAO
      
      String msg = "";
      if(status == 1)
    	  msg = "success";
      else
    	  msg = "failed";
      
      request.setAttribute("status", msg);
      RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); //something.jsp
      rd.forward(request,response);
      
	  
	   // TODO Auto-generated method stub
      //response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
