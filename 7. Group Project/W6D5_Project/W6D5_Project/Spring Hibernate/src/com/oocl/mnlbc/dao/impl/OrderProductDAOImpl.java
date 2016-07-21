package com.oocl.mnlbc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
@Repository
@Transactional
public class OrderProductDAOImpl implements OrderProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(OrderProductDAOImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public int addOrderProducts(List<OrderProduct> orderProducts) {
		for (OrderProduct orderProduct : orderProducts) {
			manager.persist(orderProduct);
			logger.info("OrderProducts saved successfully, orderproduct details=" + orderProduct);
		}
		
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
		String sql = "SELECT A.* FROM PRODUCT A, ORDERPRODUCT B " + "WHERE A.PRODID = B.PRODID " + "AND B.ORDERID = "
				+ order.getOrderId();
		List<Product> productList = manager.createNativeQuery(sql).getResultList();
		logger.info("Order id :" + order.getOrderId());
		for (Product product : productList) {
			logger.info("Product List :" + product);
		}
		return productList;
	}

	@Override
	public List<CartProduct> getCartProducts(String orderId) {
		String sql = "SELECT A.*, SUM(B.ORDERPRODQTY) AS QTY, A.PRODPRICE*A.PRODSALE*SUM(B.ORDERPRODQTY) AS SUBTOTAL FROM PRODUCT A, ORDERPRODUCT B "
				+ "WHERE A.PRODID = B.PRODID AND B.ORDERID = " + orderId
				+ "GROUP BY A.PRODID,A.PRODNAME,A.PRODCAT,A.PRODDESC,A.PRODPRICE,A.PRODSALE,A.PRODSTOCK,A.PRODIMG";
		List<CartProduct> cartProductList = manager.createNativeQuery(sql).getResultList();
		logger.info("Order id :" + orderId);
		for (CartProduct cp : cartProductList) {
			logger.info("Cart Product List :" + cp);
		}
		return cartProductList;
	}

	@Override
	public int updateOrderProduct(OrderProduct orderProduct) {
		OrderProduct newOrderProduct = manager.find(OrderProduct.class, orderProduct.getProdId());
		newOrderProduct = orderProduct;
		logger.info("OrderProduct updated successfully, Orderproduct details=" + newOrderProduct);
		return 1;
	}

}
