package com.oocl.mnlbc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.oocl.mnlbc.model.Product;

/**
 * 
 * @author Danna Soquiat
 * @since 2016-07-15 DAO Implementation for PRODUCT TABLE
 */

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public int addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Product saved successfully, Product details=" + p);
		return 1;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> listProduct() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList = session.createQuery("FROM Product").list();
		for (Product p : productList) {
			logger.info("Product List::" + p);
		}
		return productList;
	}

	@Override
	public int updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Product updated successfully, Product details" + p);
		return 1;
	}

	@Override
	public List<Product> getProductByCategory(String cat) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql =  "FROM Product WHERE PRODCAT = '" + cat + "'";
		List<Product> productList = session.createQuery(sql).list();
		for (Product p : productList) {
			logger.info("Product List::" + p);
		}
		return productList;
	}

	@Override
	public int removeProduct(int prodId) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(prodId));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Product deleted successfully!=" + p);
		return 1;
	}

	// List<Product> result = new ArrayList<Product>();
	// Connection conn = dbConnect.getConn();
	//
	// String sql = "SELECT * FROM PRODUCT";
	//
	// PreparedStatement pStmt;
	// try {
	// pStmt = (PreparedStatement) conn.prepareStatement(sql);
	// ResultSet rs = pStmt.executeQuery();
	// while (rs.next()) {
	// if (!(rs.getString("PRODID") == null)) {
	// Product prod = new Product();
	// prod.setProdId(rs.getLong("PRODID"));
	// prod.setProdName(rs.getString("PRODNAME"));
	// prod.setProdCat(rs.getString("PRODCAT"));
	// prod.setProdDesc("PRODDESC");
	// prod.setProdPrice(Double.parseDouble(rs.getString("PRODPRICE")));
	// prod.setProdStock(Integer.parseInt(rs.getString("PRODSTOCK")));
	// prod.setProdImg(rs.getString("PRODIMG"));
	// prod.setProdSale(Double.parseDouble(rs.getString("PRODSALE")));
	// result.add(prod);
	// }
	//
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// @Override
	// public int updateStock(String[] array) {
	// int result = 0;
	// Connection conn = dbConnect.getConn();
	// String sql = "UPDATE PRODUCT SET PRODSTOCK = PRODSTOCK - ? WHERE PRODID =
	// ?";
	//
	// PreparedStatement pStmt;
	// try {
	// pStmt = (PreparedStatement) conn.prepareStatement(sql);
	// pStmt.setString(1, array[1]);
	// pStmt.setString(2, array[0]);
	// result = pStmt.executeUpdate();
	// pStmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// @Override
	// public List<Product> getProductsByCategory(String category) {
	// List<Product> result = new ArrayList<Product>();
	// Connection conn = dbConnect.getConn();
	//
	// String sql = "SELECT * FROM PRODUCT WHERE PRODCAT = ?";
	//
	// PreparedStatement pStmt;
	// try {
	// pStmt = (PreparedStatement) conn.prepareStatement(sql);
	// pStmt.setString(1, category);
	// ResultSet rs = pStmt.executeQuery();
	// while (rs.next()) {
	// if (!(rs.getString("PRODID") == null)) {
	// Product prod = new Product();
	// prod.setProdId(rs.getLong("PRODID"));
	// prod.setProdName(rs.getString("PRODNAME"));
	// prod.setProdCat(rs.getString("PRODCAT"));
	// prod.setProdDesc("PRODDESC");
	// prod.setProdPrice(Double.parseDouble(rs.getString("PRODPRICE")));
	// prod.setProdStock(Integer.parseInt(rs.getString("PRODSTOCK")));
	// prod.setProdImg(rs.getString("PRODIMG"));
	// prod.setProdSale(Double.parseDouble(rs.getString("PRODSALE")));
	// result.add(prod);
	// }
	//
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// @Override
	// public Product getProduct(String id) {
	// Connection conn = dbConnect.getConn();
	// Product prod = new Product();
	// String sql = "SELECT * FROM PRODUCT WHERE PRODID = ?";
	//
	// PreparedStatement pStmt;
	// try {
	// pStmt = (PreparedStatement) conn.prepareStatement(sql);
	// pStmt.setString(1, id);
	// ResultSet rs = pStmt.executeQuery();
	// while (rs.next()) {
	// if (!(rs.getString("PRODID") == null)) {
	//
	// prod.setProdId(rs.getLong("PRODID"));
	// prod.setProdName(rs.getString("PRODNAME"));
	// prod.setProdCat(rs.getString("PRODCAT"));
	// prod.setProdDesc("PRODDESC");
	// prod.setProdPrice(Double.parseDouble(rs.getString("PRODPRICE")));
	// prod.setProdStock(Integer.parseInt(rs.getString("PRODSTOCK")));
	// prod.setProdImg(rs.getString("PRODIMG"));
	// prod.setProdSale(Double.parseDouble(rs.getString("PRODSALE")));
	// return prod;
	// }
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return prod;
	// }
	//
	// public String countProductByCat(){
	// String result = "{";
	// Connection conn = dbConnect.getConn();
	// String sql = "select count(prodid), prodcat from product group by
	// prodcat";
	//
	// PreparedStatement pStmt;
	// try {
	// pStmt = (PreparedStatement) conn.prepareStatement(sql);
	// ResultSet rs = pStmt.executeQuery();
	// while (rs.next()) {
	// if (!(rs.getString(1) == null)) {
	// result = result + '"' + rs.getString(2)+ '"' +":"+rs.getString(1)+" ";
	// }
	// }
	// result = result + "}";
	// result = result.replace(" ",",");
	// result = result.replace(result.substring(result.length()-4,
	// result.length()),
	// result.substring(result.length()-4, result.length()).replace(",", ""));
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return result;
	// }
	//
	// public List<OrderProduct> getOrderProd(User user){
	// List<OrderProduct> orderProdList = new ArrayList<OrderProduct>();
	// Connection conn = dbConnect.getConn();
	// String sql = "SELECT A.ORDERID, A.PRODID,SUM(A.ORDERPRODQTY) AS QTY FROM
	// ORDERPRODUCT A, ORDERS B, USERS C "
	// + "WHERE C.USERID = 1 AND C.USERID = B.USERID AND B.ORDERDATE IS NULL "
	// + "AND B.ORDERID = A.ORDERID GROUP BY A.ORDERID,A.PRODID";
	// PreparedStatement pStmt;
	// try {
	// pStmt = (PreparedStatement) conn.prepareStatement(sql);
	// pStmt.setLong(1, user.getUserId());
	// ResultSet rs = pStmt.executeQuery();
	// while(rs.next()){
	// OrderProduct orderProd = new OrderProduct();
	// orderProd.setOrderProdId(rs.getLong("PRODID"));
	// orderProd.setOrderId(rs.getLong("ORDERID"));
	// orderProd.setOrderProdQty(rs.getInt("QTY"));
	// orderProdList.add(orderProd);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return orderProdList;
	// }
	// @Override
	// public void addProduct(Product p) {
	// // TODO Auto-generated method stub
	//
	// }
	// @Override
	// public void updateProduct(Product p) {
	// // TODO Auto-generated method stub
	//
	// }
	// @Override
	// public Product getProductByCategory(int id) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// @Override
	// public void removeProduct(int id) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void addProduct(Product p) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void updateProduct(Product p) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public List<Product> listProduct() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Product getProductByCategory(int id) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
