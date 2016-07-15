package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.util.JsonParser;
import com.oocl.mnlbc.util.LogUtil;
import com.oocl.mnlbc.dao.OrderProductDAOImpl;
import com.oocl.mnlbc.dao.OrdersDAOImpl;
import com.oocl.mnlbc.dao.ProductDAOImpl;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.util.LogType;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public AddToCart() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   @SuppressWarnings("unchecked")
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      ProductDAOImpl prodDAO = new ProductDAOImpl();
      OrdersDAOImpl orderDAO = new OrdersDAOImpl();
      String id = request.getParameter("prodId");
      String qty = request.getParameter("prodQty");
      User user = (User) session.getAttribute("user");
      Product prod = prodDAO.getProduct(id);
      OrderProductDAOImpl opDAO = new OrderProductDAOImpl();
      if (orderDAO.getOrderId(user) == null) {
         orderDAO.createOrder(user);
      }
      Order order = new Order();
      order = (Order) session.getAttribute("order");
      opDAO.addProduct(order, prod, 1);

      if (session.getAttribute("cartList") == null) {
         session.setAttribute("cartList", new ArrayList<String[]>());
         session.setAttribute("cartItems", new Integer(0));
      }

      List<String[]> cartList = (List<String[]>) session.getAttribute("cartList");
      Integer cartItems = (Integer) session.getAttribute("cartItems");
      String[] array = { id, "1" };
      if (cartItems == 0) {
         cartList.add(array);
         cartItems = cartItems + 1;
      } else {
         for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i)[0].equals(array[0])) {
               cartList.get(i)[1] = String.valueOf(Integer.parseInt(cartList.get(i)[1]) + 1);
            } else {
               cartList.add(array);
               cartItems = cartItems + 1;
            }
         }
      }
      session.setAttribute("cartItems", cartItems);
      session.setAttribute("cartList", cartList);

      LogUtil.logMsg(LogType.INFO, "CartItems: " + cartItems);
      String msg = "";
      msg = JsonParser.toProductJson(opDAO.getRelatedProducts(orderDAO.getOrder(user)));
      response.getWriter().append(msg);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
   }

}
