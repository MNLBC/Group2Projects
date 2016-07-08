package com.oocl.mnlbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.Product;

public class OrderProductDAOImpl implements OrderProductDAO {
	DatabaseConnection dbConnect = new DatabaseConnection();

	@Override
	public int addProduct(Order order, Product prod, int qty) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "INSERT INTO ORDERPRODUCT(ORDERID,PRODID,QTY) VALUES(?,?,?)";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, order.getOrderId());
			pStmt.setLong(2, prod.getProductId());
			pStmt.setInt(3, qty);
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
	public int removeProduct(long orderProductId) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "DELETE FROM ORDERPRODUCT WHERE ORDERPRODUCTID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, orderProductId);
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
	public List<Product> getRelatedProducts(Order order) {
		List<Product> result = new ArrayList<Product>();
		Connection conn = dbConnect.getConn();
		String sql = "SELECT A.* FROM PRODUCT A, ORDERPRODUCT B "
				+ "WHERE A.PRODID = B.PRODID "
				+ "AND B.ORDERID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, order.getOrderId());
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				Product prod = new Product();
				prod.setProductId(rs.getLong("PRODID"));
				prod.setProductName("PRODNAME");
				prod.setProductCategory("CATEGORY");
				prod.setProductPrice(Double.parseDouble(rs.getString("PRICE")));
				prod.setProductStock(Integer.parseInt(rs.getString("STOCK")));
				prod.setProductImg(rs.getString("IMG"));
				result.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
