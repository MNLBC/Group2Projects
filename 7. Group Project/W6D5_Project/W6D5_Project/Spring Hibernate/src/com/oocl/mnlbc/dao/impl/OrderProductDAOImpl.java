package com.oocl.mnlbc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oocl.mnlbc.dao.inf.OrderProductDAO;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;

/**
 * 
 * @author kalinwi2
 * DAO Implementation for ORDERPRODUCT TABLE
 */
public class OrderProductDAOImpl implements OrderProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(OrderProductDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public int addOrderProduct(OrderProduct op) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(op);
		logger.info("OrderProduct saved successfully, orderproduct details="+op);
		return 1;
	}

	@Override
	public int removeOrderProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OrderProduct op = (OrderProduct) session.load(OrderProduct.class, new Integer(id));
		if(null != op){
			session.delete(op);
		}
		logger.info("OrderProduct deleted successfully, OrderProduct details="+op);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getRelatedProducts(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT A.* FROM PRODUCT A, ORDERPRODUCT B "
				+ "WHERE A.PRODID = B.PRODID "
				+ "AND B.ORDERID = "+order.getOrderId();
		List<Product> productList = session.createQuery(sql).list();
		logger.info("Order id :"+order.getOrderId());
		for(Product p : productList){
			logger.info("Product List :"+p);
		}
		return productList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartProduct> getCartProducts(String orderId) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT A.*, SUM(B.ORDERPRODQTY) AS QTY, A.PRODPRICE*A.PRODSALE*SUM(B.ORDERPRODQTY) AS SUBTOTAL FROM PRODUCT A, ORDERPRODUCT B "
				+ "WHERE A.PRODID = B.PRODID AND B.ORDERID = " + orderId
				+ "GROUP BY A.PRODID,A.PRODNAME,A.PRODCAT,A.PRODDESC,A.PRODPRICE,A.PRODSALE,A.PRODSTOCK,A.PRODIMG";
		List<CartProduct> cartProductList = session.createQuery(sql).list();
		logger.info("Order id :"+orderId);
		for(CartProduct cp : cartProductList){
			logger.info("Cart Product List :"+cp);
		}
		return cartProductList;
	}

	@Override
	public int updateOrderProduct(OrderProduct op) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(op);
		logger.info("OrderProduct updated successfully, Orderproduct details="+op);
		return 1;
	}
	
}
