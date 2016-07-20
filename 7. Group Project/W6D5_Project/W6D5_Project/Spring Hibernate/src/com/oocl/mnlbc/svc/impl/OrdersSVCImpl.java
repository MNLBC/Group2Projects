package com.oocl.mnlbc.svc.impl;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.OrdersDAO;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.OrdersSVC;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc Implementation for ORDERS TABLE
 * @date 07-15-2016
 */
public class OrdersSVCImpl implements OrdersSVC {

	private OrdersDAO orderDAO;

	public void setOrderDAO(OrdersDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	@Transactional
	public int createOrder(Order order) {
		return this.orderDAO.createOrder(order);
	}

	@Override
	@Transactional
	public int cancelOrder(Order order) {
		int id = (int) order.getOrderId();
		return this.orderDAO.cancelOrder(id);
	}

//	@Override
//	@Transactional
//	public int finalOrder(Order order, String timestamp) {
//		return this.orderDAO.finalOrder(order, timestamp);
//	}
//
//	@Override
//	@Transactional
//	public Order getOrderId(User user) {
//		return this.orderDAO.getOrderId(user);
//	}

	// @Override
	@Transactional
	public Order getOrder(User user) {
		// return this.orderDAO.getOrder(user);
		return null;
	}

}
