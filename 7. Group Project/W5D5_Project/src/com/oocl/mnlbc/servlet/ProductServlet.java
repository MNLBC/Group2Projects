package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.dao.ProductDAOImpl;
import com.oocl.mnlbc.util.JsonParser;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/getProducts")
public class ProductServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public ProductServlet() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      ProductDAOImpl prodDao = new ProductDAOImpl();
      String category = request.getParameter("category");
      String msg = "";
      List<Product> prodList = new ArrayList<Product>();
      if (category == null) {
         prodList = prodDao.getProducts();
      } else {
         prodList = prodDao.getProductsByCategory(category);
      }
      msg = JsonParser.toProductJson(prodList);
      response.getWriter().append(msg);
      // response.getWriter().append(prodDao.countProductByCat());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
   }

}
