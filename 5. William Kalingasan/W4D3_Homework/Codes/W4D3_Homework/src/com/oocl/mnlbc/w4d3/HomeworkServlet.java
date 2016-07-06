package com.oocl.mnlbc.w4d3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeworkServlet
 */
@WebServlet("/registeruser")
public class HomeworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeworkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatabaseUtil dbUtil = new DatabaseUtil();
		PrintWriter out = response.getWriter();
		String username,password,confirmpass,firstname,lastname;
		
		username = request.getParameter("username");
		password = request.getParameter("pword");
		confirmpass = request.getParameter("confirmpword");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		
		
		boolean exists = dbUtil.userFound(username);
		if(!exists){
			if(password.equals(confirmpass)){
				dbUtil.createAccount(firstname, lastname, username, password);
				out.println("<script>alert('User " + username + " has been created for " + firstname + " " + lastname +"');</script>");
				out.println("<html>\n" +
							"<body>\n<center><h1>Welcome " + firstname + " " + lastname + "</h1></center></body>\n" +
							"</html>");
			}
			else{
				//out.println("<script>alert('Passwords Don't Match!');</script>");
				//out.println("Click here to go back<br><button location.href='D:\\Workspace2\\W4D3_Homework\\WebContent\\index.html'>"
				//		+ "GO BACK</button>");
				
				request.setAttribute("req", "Passwords Don't Match");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}
		}
		else{
			request.setAttribute("req", "User Already Exists");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
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
