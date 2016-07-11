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

import com.oocl.mnlbc.dao.OrderProductDAOImpl;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderProductDAOImpl orderProdDAO = new OrderProductDAOImpl();
		HttpSession session = request.getSession();
		try{
			int removeQty = (int) request.getAttribute("removeQty");
			String orderId = (String) request.getAttribute("orderId");
			String productId = (String) request.getAttribute("productId");
			List<String[]> cartList = new ArrayList<String[]>();
			cartList = (List<String[]>) session.getAttribute("cartList");
			if(removeQty >= 1){
				orderProdDAO.removeProduct(orderId,productId,removeQty);
				for(int i = 0; i < cartList.size();i++){
					if(cartList.get(i)[0].equals(productId)){
						int newQty = Integer.parseInt(cartList.get(i)[1]) - removeQty;
						cartList.get(i)[1] = String.valueOf(newQty);
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
