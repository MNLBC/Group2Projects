package com.oocl.mnlbc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.bean.*;
import com.oocl.mnlbc.dao.*;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getAttribute("action");
		String lastURL = (String) request.getAttribute("lastURL");
		int result = 0;
		String msg = "";
		
		//USER EDIT
		UserDAOImpl userDAO = new UserDAOImpl();
		User user = (User) request.getAttribute("user");
		
		if(action.equals("updateusertype")){
			String type = (String) request.getAttribute("type");
			result = userDAO.updateUserType(user, type);
		}
		
		//PRODUCT EDIT
		ProductDAOImpl prodDAO = new ProductDAOImpl();
		Product product = (Product) request.getAttribute("product");
		if(action.equals("updatestock")){
			int qty = (int) request.getAttribute("qty");
			result = prodDAO.updateStock(product, qty);
		}
		
		if(result == 1)
			msg = "success";
		else
			msg = "failed";
		
		request.setAttribute("status", msg);
	    RequestDispatcher rd = request.getRequestDispatcher(lastURL); //something.jsp
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
