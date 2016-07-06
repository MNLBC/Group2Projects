package com.oocl.mnlbc.w4d3homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confpword = request.getParameter("confpassword");
		
		if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty())
		{
     		out.println("<font color=red>All fields are required to be filled!</font>");
		
		}
		else
		{			
			boolean exists = userFound(username);
			if(!exists){
				if(password.equals(confpword)){
					regUser(firstname, lastname, username, password);
					out.println("<script>alert('User " + username + " has been created for " + firstname + " " + lastname +"');</script>");
					out.println("<html>\n" +
								"<body>\n<center><h1>Welcome " + firstname + " " + lastname + "</h1></center></body>\n" +
								"</html>");
				}
				else{
					//out.println("<script>alert('Passwords Don't Match!');</script>");
					//out.println("Click here to go back<br><button location.href='D:\\Workspace2\\W4D3_Homework\\WebContent\\index.html'>"
					//		+ "GO BACK</button>");
					
					request.setAttribute("req", "pass");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request,response);
				}
			}
			else{
				request.setAttribute("req", "user");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean userFound(String username){
		boolean result = false;
		Connection conn = getConn();
		
		String sql = "SELECT * FROM HOMEWORK_USERS WHERE USERNAME = ?";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(rs.getString("USERNAME").equals(username)){
					result = true;
					return result;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public static boolean validateUser(String uname){
	   Connection conn = getConn();
	      PreparedStatement pstmt;
	      ResultSet rs;
	      String result;
	      String sql = "SELECT uname FROM HOMEWORK_USERS";
	      
	      try {
	         pstmt = (PreparedStatement) conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while(rs.next()){
	            if(rs.getString(1).equals(uname)){
	               return true;
	            }
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return false;
	}

	public static void regUser(String fname, String lname, String uname, String pword){
	   Connection conn = getConn();
	   PreparedStatement pstmt;
	   String sql = "INSERT INTO HOMEWORK_USERS VALUES(?,?,?,?)";
	   
	   try {
	         pstmt = (PreparedStatement) conn.prepareStatement(sql);
	         pstmt.setString(1, fname);
	         pstmt.setString(2, lname);
	         pstmt.setString(3, uname);
	         pstmt.setString(4, pword);
	         pstmt.executeUpdate();
	         pstmt.close();
	         conn.close();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}

	public static Connection getConn(){
	   String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String username = "tutor";
	      String password = "oracle";
	      Connection conn = null;
	      
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url, username, password);
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return conn;
	}
	
}
