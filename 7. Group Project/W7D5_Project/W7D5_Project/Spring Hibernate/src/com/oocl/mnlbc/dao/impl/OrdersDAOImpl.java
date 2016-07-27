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
import com.oocl.mnlbc.model.User;

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
		String sql = "Select orders From Order orders where orders.userId=:userId";
		Query query = manager.createQuery(sql, Order.class);
		query.setParameter("userId", userId);
		orderList = query.getResultList();
		for (Order order : orderList) {
			logger.info("Order list" + order);
		}
		return orderList;

	}

	@Override
	public int getOrderByUserId(long userId) {
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT MAX(ORDERID) AS ORDERID, USERID FROM ORDERS WHERE USERID = :userId GROUP BY USERID";
		Query query = manager.createNativeQuery(sql);
		query.setParameter("userId", userId);
		List<Object[]> o = query.getResultList();
		int orderId = 0;
		for (int i = 0; i < o.size(); i++) {
			BigDecimal d = (BigDecimal) o.get(i)[0];
			orderId = d.intValue();
		}
		return orderId;
	}

	@Override
	public boolean isPremium(long userId) {
		boolean result = false;
		String sql = "SELECT user FROM User user WHERE user.userId= :userId AND user.userLevel = 2";
		Query query = manager.createQuery(sql);
		query.setParameter("userId", userId);
		List<User> user = query.getResultList();
		if (!user.isEmpty()) {
			try {
				result = true;
			} catch (Exception e) {
				result = false;
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orderList = new ArrayList<Order>();
		String query = "Select orders From Order orders";
		orderList = manager.createQuery(query, Order.class).getResultList();
		for (Order order : orderList) {
			logger.info("Order list" + order);
		}
		return orderList;
	}

	@Override
	public int updateOrder(Order order) {
		Order newOrder = manager.find(Order.class, order.getOrderId());
		newOrder.setOrderId(order.getOrderId());
		newOrder.setOrderDate(order.getOrderDate());
		newOrder.setOrderTotal(order.getOrderTotal());
		newOrder.setUserId(order.getUserId());
		
		logger.info("Order updated successfully!=" + newOrder);
		return 1;
	}

	@Override
	public int deleteOrderById(long orderId) {
		Order deletedOrder = manager.find(Order.class, orderId);
		manager.remove(deletedOrder);
		logger.info("Order deleted successfully!=" + deletedOrder);
		return 1;
	}
	

}
