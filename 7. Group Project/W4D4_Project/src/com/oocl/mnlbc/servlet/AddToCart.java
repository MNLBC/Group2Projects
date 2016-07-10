package com.oocl.mnlbc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.bean.Product;
import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.dao.OrderProductDAOImpl;
import com.oocl.mnlbc.dao.OrdersDAOImpl;
import com.oocl.mnlbc.dao.ProductDAOImpl;
import com.oocl.mnlbc.util.JsonParser;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ProductDAOImpl prodDAO = new ProductDAOImpl();
		OrdersDAOImpl orderDAO = new OrdersDAOImpl();
		String id = request.getParameter("prodId");
		String qty = request.getParameter("prodQty");
		User user = (User) session.getAttribute("user");
		Product prod = prodDAO.getProduct(id);
		OrderProductDAOImpl opDAO = new OrderProductDAOImpl();
		opDAO.addProduct(orderDAO.getOrderId(user), prod, 1);
		
		String msg = "";
		msg = JsonParser.toProductJson(opDAO.getRelatedProducts(orderDAO.getOrder(user)));
		response.getWriter().append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
