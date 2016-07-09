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

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.Product;
import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.OrderProductDAOImpl;
import com.oocl.mnlbc.dao.OrdersDAOImpl;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
		OrderProductDAOImpl ordersProdDAO = new OrderProductDAOImpl();
		User user = (User) session.getAttribute("user");
		Order order = ordersDAO.getOrderId(user);
		List<Product> productList= ordersProdDAO.getRelatedProducts(order);
		
		session.setAttribute("orderProductList", productList);
		
		RequestDispatcher rd = request.getRequestDispatcher("checkout.html"); //something.jsp
	    rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
