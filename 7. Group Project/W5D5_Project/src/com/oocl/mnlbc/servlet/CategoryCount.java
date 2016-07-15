package com.oocl.mnlbc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.ProductDAOImpl;

/**
 * Servlet implementation class CategoryCount
 */
@WebServlet("/CategoryCount")
public class CategoryCount extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public CategoryCount() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ProductDAOImpl prodDao = new ProductDAOImpl();
      response.getWriter().append(prodDao.countProductByCat());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
   }

}
