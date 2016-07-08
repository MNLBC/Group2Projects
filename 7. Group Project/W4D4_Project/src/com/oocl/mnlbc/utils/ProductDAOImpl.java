package com.oocl.mnlbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.bean.Product;

public class ProductDAOImpl implements ProductDAO {
	
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
	public List<Product> getProducts() {
		List<Product> result = new ArrayList<Product>();
		Connection conn = getConn();
		
		String sql = "SELECT * FROM PRODUCT";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				if(!(rs.getString("PRODID")==null)){
					Product prod = new Product();
					prod.setProductId(rs.getLong("PRODID"));
					prod.setProductName("PRODNAME");
					prod.setProductCategory("CATEGORY");
					prod.setProductPrice(Double.parseDouble(rs.getString("PRICE")));
					prod.setProductStock(Integer.parseInt(rs.getString("STOCK")));
					prod.setProductImg(rs.getString("IMG"));
					result.add(prod);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStock(Product product, int newStock) {
		int result = 0;
		Connection conn = getConn();
		String sql = "UPDATE PRODUCT SET STOCK = ? WHERE PRODID = ?";
		
		PreparedStatement pStmt;
		try {
			pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setInt(1, newStock);
			pStmt.setLong(2, product.getProductId());
			result = pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

}
