package com.oocl.mnlbc.dao;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.model.Product;


/**
 * 
 * @author Lance Jasper Lopez
 * @desc SVC Implementation for PRODUCT TABLE
 * @date 07-15-2016
 * 
 */

@Service
public class ProductSVCImpl implements ProductSVC {

	private ProductDAO prodDAO;

	public void setProductDAO(ProductDAO prodDAO) {
		this.prodDAO = prodDAO;
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return this.prodDAO.listProduct();
	}



	@Override
	@Transactional
	public List<Product> getProductsByCategory(String category) {
		return this.prodDAO.getProductByCategory(category);
	}

//	@Override
//	@Transactional
//	public Product getProduct(String id) {
//		return this.prodDAO.getProduct(id);
//	}

	public String countProductByCat() {
//		return this.prodDAO.countProductByCat();
		return null;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		return this.prodDAO.addProduct(p);
	}

	@Override
	public int updateProduct(Product p) {
		// TODO Auto-generated method stub
		return this.prodDAO.updateProduct(p);
	}

	@Override
	public int removeProduct(int id) {
		// TODO Auto-generated method stub
		return this.prodDAO.removeProduct(id);
		
	}

//	public List<OrderProduct> getOrderProd(User user) {
//		List<OrderProduct> orderProdList = new ArrayList<OrderProduct>();
//		Connection conn = dbConnect.getConn();
//		String sql = "SELECT A.ORDERID, A.PRODID,SUM(A.ORDERPRODQTY) AS QTY FROM ORDERPRODUCT A, ORDERS B, USERS C "
//				+ "WHERE C.USERID = 1 AND C.USERID = B.USERID AND B.ORDERDATE IS NULL "
//				+ "AND B.ORDERID = A.ORDERID GROUP BY A.ORDERID,A.PRODID";
//		PreparedStatement pStmt;
//		try {
//			pStmt = (PreparedStatement) conn.prepareStatement(sql);
//			pStmt.setLong(1, user.getUserId());
//			ResultSet rs = pStmt.executeQuery();
//			while (rs.next()) {
//				OrderProduct orderProd = new OrderProduct();
//				orderProd.setOrderProdId(rs.getLong("PRODID"));
//				orderProd.setOrderId(rs.getLong("ORDERID"));
//				orderProd.setOrderProdQty(rs.getInt("QTY"));
//				orderProdList.add(orderProd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return orderProdList;
//	}

}