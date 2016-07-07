package com.oocl.mnlbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAOImpl implements OrdersDAO {

	private Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String username = "GROUP2";
	      String password = "GROUP2";
	      Connection conn = null;
	      try {
	         Class.forName(driver);
	         conn = (Connection) DriverManager.getConnection(url, username, password);
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return conn;
	}
	
	@Override
	public int createOrder(long userId) {
		int result = 0;
		Connection conn = getConn();
		String sql = "INSERT INTO ORDERS(USERID) VALUES(?)";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, userId);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int cancelOrder(long orderId) {
		int result = 0;
		Connection conn = getConn();
		String sql = "DELETE FROM ORDERS WHERE ORDERID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, orderId);
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int finalOrder(long orderId) {
		int result = 0;
		String total = "";
		Connection conn = getConn();
		String sql;
		
		sql = "SELECT SUM(A.PRICE * B.QTY) AS TOTAL, A.PRODID "
				+ "FROM PRODUCT A, ORDERPRODUCT B "
				+ "WHERE A.PRODID = B.PRODID "
				+ "AND B.ORDERID = ? "
				+ "GROUP BY A.PRODID";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, orderId);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				total = rs.getString(1);
			}
			sql = "UPDATE ORDERS SET TOTAL = ?, ORDER_DT = SYSDATE";
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1,total);
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
