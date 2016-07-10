package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.Product;
import com.oocl.mnlbc.util.DbConnection;

/**
 * 
 * @author kalinwi2
 * DAO Implementation for ORDERPRODUCT TABLE
 */
public class OrderProductDAOImpl implements OrderProductDAO {
	DbConnection dbConnect = new DbConnection();

	@Override
	public int addProduct(Order order, Product prod, int qty) {
		int result = 0;
		Connection conn = dbConnect.getConn();
		String sql = "INSERT INTO ORDERPRODUCT(ORDERID,PRODID,ORDERPRODQTY) VALUES(?,?,?)";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setLong(1, order.getOrderId());
			pStmt.setLong(2, prod.getProdId());
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
		String sql = "DELETE FROM ORDERPRODUCT WHERE ORDERPRODID = ?";
		
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
				prod.setProdId(rs.getLong("PRODID"));
				prod.setProdName(rs.getString("PRODNAME"));
				prod.setProdCat(rs.getString("PRODCAT"));
				prod.setProdPrice(Double.parseDouble(rs.getString("PRODPRICE")));
				prod.setProdStock(Integer.parseInt(rs.getString("PRODSTOCK")));
				prod.setProdImg(rs.getString("PRODIMG"));
				prod.setProdSale(Double.parseDouble(rs.getString("PRODSALE")));
				result.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
