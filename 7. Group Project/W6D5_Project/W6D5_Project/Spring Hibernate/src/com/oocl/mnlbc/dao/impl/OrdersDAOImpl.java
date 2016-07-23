package com.oocl.mnlbc.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.OrdersDAO;
import com.oocl.mnlbc.model.Order;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc Migration from Hibernate to JPA DAO Implementation for ORDERS TABLE
 * @since 07/21/2016
 */
@Repository
@Transactional
public class OrdersDAOImpl implements OrdersDAO {
	private static final Logger logger = LoggerFactory.getLogger(OrdersDAOImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public int createOrder(Order order) {
		manager.persist(order);
		logger.info("Order saved successfully, Order details=" + order);
		return 1;
	}

	@Override
	public int cancelOrder(long id) {

		Order removeOrder = manager.find(Order.class, id);
		manager.remove(removeOrder);
		logger.info("Order deleted successfully, Order details=" + removeOrder);
		return 1;
	}

	@Override
	public List<Order> getOrdersByUser(long userId) {

		List<Order> orderList = new ArrayList<Order>();
		String query = "Select orders From Order orders where orders.userId=" + userId;
		orderList = manager.createQuery(query, Order.class).getResultList();
		for (Order order : orderList) {
			logger.info("Order list" + order);
		}
		return orderList;

	}

	@Override
	public int getOrderByUserId(long userId) {
		List<Order> orders = new ArrayList<Order>();
		Query query = manager.createNativeQuery("SELECT MAX(ORDERID) AS ORDERID, USERID FROM ORDERS WHERE USERID ='" + userId + "' "
				+ "GROUP BY USERID");
		List<Object[]> o = query.getResultList();
		int orderId = 0;
		for(int i = 0; i < o.size();i++){
			BigDecimal d = (BigDecimal) o.get(i)[0];
			orderId = d.intValue();
		}
		return orderId;
	}

}
