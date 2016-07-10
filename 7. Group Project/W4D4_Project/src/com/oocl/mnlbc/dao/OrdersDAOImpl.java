package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.User;
import com.oocl.mnlbc.util.DbConnection;

/**
 * 
 * @author kalinwi2
 * DAO Implementation for ORDERS TABLE
 */
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
		
		sql = "SELECT SUM((A.PRODPRICE*A.PRODSALE) * B.ORDERPRODQTY) AS TOTAL, A.PRODID "
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
			sql = "UPDATE ORDERS SET ORDERTOTAL = ?, ORDERDATE = ?";
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

	@Override
	public Order getOrderId(User user) {
		Order order = new Order();
		Connection conn = dbConnect.getConn();
		String sql = "SELECT ORDERID, USERID FROM ORDERS WHERE USERID = ? "
				+ "AND ORDERDATE IS NULL AND ORDERTOTAL IS NULL";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, user.getUserId());
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!rs.getString(1).equals("")){
					order.setOrderId(rs.getLong(1));
					order.setUserId(rs.getLong(2));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	public Order getOrder(User user) {
		Order order = new Order();
		Connection conn = dbConnect.getConn();
		String sql = "SELECT * FROM ORDERS WHERE USERID = ? "
				+ "AND ORDERDATE IS NULL AND ORDERTOTAL IS NULL";
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, user.getUserId());
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!rs.getString(1).equals("")){
					order.setOrderId(rs.getLong(1));
					order.setUserId(rs.getLong(2));
					order.setOrderTotal(rs.getDouble(3));
					order.setOrderDate(rs.getString(4));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

}
