package com.oocl.mnlbc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.OrderProductDAO;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc Migration from Hibernate to JPA DAO Implementation for ORDERS TABLE
 * @since 07/21/2016
 */

/**
 * 
 * @author Lance Jasper Lopez
 * @since 07/27/2016
 * @desc JPA Query Modification to prevent SQL Injection
 *
 */
@Repository
@Transactional
public class OrderProductDAOImpl implements OrderProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(OrderProductDAOImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public int addOrderProducts(List<CartProduct> cartProductList, int orderId, long userId) {
		for (CartProduct cart : cartProductList) {
			String insertSql = "INSERT INTO ORDERPRODUCT(ORDERID,PRODID,ORDERPRODQTY) VALUES(:orderId, :prodId , :prodQty)";
			Query query = manager.createNativeQuery(insertSql);
			query.setParameter("orderId", orderId);
			query.setParameter("prodId", cart.getProdId());
			query.setParameter("prodQty", cart.getProdQty());
			query.executeUpdate();

			String updateSql = "UPDATE PRODUCT SET PRODSTOCK = PRODSTOCK - :prodQty WHERE PRODID = :prodId";
			query = manager.createNativeQuery(updateSql);
			query.setParameter("prodQty", cart.getProdQty());
			query.setParameter("prodId", cart.getProdId());
			query.executeUpdate();
			logger.info("OrderProducts saved successfully, orderproduct details=" + cartProductList);
		}
		String deleteSql = "DELETE FROM CARTPRODUCT WHERE USERID = :userId";
		Query query = manager.createNativeQuery(deleteSql);
		query.setParameter("userId", userId);
		query.executeUpdate();
		return 1;
	}

	@Override
	public int removeOrderProduct(long id) {
		OrderProduct removeOrderProduct = manager.find(OrderProduct.class, id);
		manager.remove(removeOrderProduct);
		logger.info("OrderProduct deleted successfully, OrderProduct details=" + removeOrderProduct);
		return 1;
	}

	@Override
	public List<Product> getRelatedProducts(Order order) {
		String sql = "SELECT A.* FROM PRODUCT A, ORDERPRODUCT B WHERE A.PRODID = B.PRODID AND B.ORDERID = :orderId";
		Query query = manager.createNativeQuery(sql);
		query.setParameter("orderId", order.getOrderId());
		List<Product> productList = query.getResultList();
		logger.info("Order id :" + order.getOrderId());
		for (Product product : productList) {
			logger.info("Product List :" + product);
		}
		return productList;
	}

	@Override
	public List<CartProduct> getCartProducts(String orderId) {
		String sql = "SELECT A.*, SUM(B.ORDERPRODQTY) AS QTY, A.PRODPRICE*A.PRODSALE*SUM(B.ORDERPRODQTY) AS SUBTOTAL "
				+ "FROM PRODUCT A, ORDERPRODUCT B " + "WHERE A.PRODID = B.PRODID AND B.ORDERID = :orderId "
				+ "GROUP BY A.PRODID,A.PRODNAME,A.PRODCAT,A.PRODDESC,A.PRODPRICE,A.PRODSALE,A.PRODSTOCK,A.PRODIMG";
		Query query = manager.createNativeQuery(sql);
		query.setParameter("orderId", orderId);
		List<CartProduct> cartProductList = query.getResultList();
		logger.info("Order id :" + orderId);
		for (CartProduct cp : cartProductList) {
			logger.info("Cart Product List :" + cp);
		}
		return cartProductList;
	}

	@Override
	public int updateOrderProduct(OrderProduct orderProduct) {
		OrderProduct newOrderProduct = manager.find(OrderProduct.class, orderProduct.getProdId());
		newOrderProduct.setOrderId(orderProduct.getOrderId());
		newOrderProduct.setOrderProdId(orderProduct.getOrderProdId());
		newOrderProduct.setOrderProdQty(orderProduct.getOrderProdQty());
		newOrderProduct.setProdId(orderProduct.getProdId());
		logger.info("OrderProduct updated successfully, Orderproduct details=" + newOrderProduct);
		return 1;
	}

	@Override
	public List<CartProduct> getCartProductByUserId(long userId) {
		String sql = "SELECT * FROM CARTPRODUCT WHERE USERID = :userId";
		Query query = manager.createNativeQuery(sql, CartProduct.class);
		query.setParameter("userId", userId);
		List<CartProduct> cartProductList = query.getResultList();
		logger.info("User id :" + userId);
		for (CartProduct cp : cartProductList) {
			logger.info("Cart Product List :" + cp);
		}
		return cartProductList;
	}

   @Override
   public List<OrderProduct> getOrderProductsByOrder(long orderid) {
      String sql = "SELECT orderproduct FROM OrderProduct orderproduct WHERE orderproduct.orderId = :orderId";
      Query query = manager.createQuery(sql);
      query.setParameter("orderId", orderid);
      List<OrderProduct> orderProductList = query.getResultList();
      logger.info("Order id :" + orderid);
      for (OrderProduct orderproduct : orderProductList) {
         logger.info("Order Product List :" + orderproduct);
      }
      return orderProductList;
   }

}
