package com.oocl.mnlbc.hw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userProcessor
 */

@WebServlet("/createUser")
public class userProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userProcessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String driverName = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "system";
		String password = "admin";
		PrintWriter print = response.getWriter();
		try {
			Connection conn = DriverManager.getConnection(URL, userName, password);

			Statement sqlStatement = conn.createStatement();

			// ResultSet resultSet = sqlStatement.executeQuery("SELECT * from
			// ACCOUNTS");
			// while(resultSet.next()){
			// System.out.println(resultSet);

			response.setContentType("text/html");

			String fullName = "";
			String email = "";
			String pass = "";
			String confirmPass = "";
			String sql = "";

			fullName = request.getParameter("name");
			email = request.getParameter("email");
			pass = request.getParameter("pass");
			confirmPass = request.getParameter("confirmPass");

			String searchRecord = "";
			searchRecord = "SELECT * FROM ACCOUNTS WHERE EMAIL ='" + email + "'";
			ResultSet resultSet = sqlStatement.executeQuery(searchRecord);
			if (resultSet.next()) {
				print.println("Account already exists");
			} else {
				if (fullName != null && email != null && pass != null && confirmPass != null) {
					if (pass.equals(confirmPass)) {
						sql = "INSERT INTO ACCOUNTS(EMAIL,NAME,PASSWORD) " + "VALUES('" + email + "','" + fullName
								+ "','" + pass + "')";
						sqlStatement.executeQuery(sql);
						print.println("Successfully inserted record");
					} else {
						print.println("Password does not match");
						print.println("Failed to insert record");
					}
				} else {
					print.println("Please complete the necessary fields");
					print.println("Failed to insert record");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			print.println("Failed to insert record");
		}

	}

}
