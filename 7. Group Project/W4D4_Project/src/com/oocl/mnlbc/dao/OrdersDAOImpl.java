package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.utils.DbConnection;

public class OrdersDAOImpl implements OrdersDAO {

   DbConnection dbConnect = new DbConnection();
	
	@Override
	public int createOrder(User user) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "INSERT INTO ORDERS(USERID) VALUES(?)";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, user.getUserId());
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
	public int cancelOrder(Order order) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "DELETE FROM ORDERS WHERE ORDERID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, order.getOrderId());
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
	public int finalOrder(Order order, String timestamp) {
		int result = 0;
		String total = "";
		Connection conn = dbConnect.getConn();
		String sql;
		
		sql = "SELECT SUM(A.PRICE * B.QTY) AS TOTAL, A.PRODID "
				+ "FROM PRODUCT A, ORDERPRODUCT B "
				+ "WHERE A.PRODID = B.PRODID "
				+ "AND B.ORDERID = ? "
				+ "GROUP BY A.PRODID";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, order.getOrderId());
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				total =  total + rs.getDouble(1);
			}
			sql = "UPDATE ORDERS SET TOTAL = ?, ORDER_DT = ?";
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1,total);
			pStmt.setString(2,timestamp);
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
