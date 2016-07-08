package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.util.Config;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/test/testfilter")
public class TestServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public TestServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      String account = request.getParameter("account");
      String pwd = request.getParameter("pwd");
      String type = request.getParameter("type");
      String msg = Config.getConfigValue("user");
      // RequestDispatcher requestDispatcher = request.getRequestDispatcher("app/welcome.jsp");
      // requestDispatcher.forward(request, response);
      response.getWriter().append(msg);
      response.getWriter().append("success");
      // PrintWriter out = response.getWriter();
      // out.append("<!DOCTYPE HTML>");
      // out.append("<HTML>");
      // out.append("</HTML>");
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
