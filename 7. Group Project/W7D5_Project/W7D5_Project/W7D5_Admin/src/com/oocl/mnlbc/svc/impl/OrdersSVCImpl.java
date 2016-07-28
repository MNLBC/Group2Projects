package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.OrdersDAO;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.OrdersSVC;
import com.oocl.mnlbc.util.Timestamp;

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
	public int cancelOrder(Order order) {
		int id = (int) order.getOrderId();
		return this.orderDAO.cancelOrder(id);
	}

	@Override
	@Transactional
	public int createOrder(long userid, List<CartProduct> cartProductList) {
		Order order = new Order();
		order.setOrderDate(Timestamp.getTimestamp());
		order.setUserId(userid);
		float total = 0;
		for (CartProduct cart : cartProductList) {
			total += cart.getProdSubtotal();
		}
		boolean isPremium = this.orderDAO.isPremium(userid);
		if (isPremium) {
			float discount = (float) (total * 0.1);
			total = total - discount;
			order.setOrderTotal(total);
		} else {
			order.setOrderTotal(total);
		}

		return this.orderDAO.createOrder(order);
	}

	@Override
	@Transactional
	public List<Order> getOrdersByUser(long userid) {
		return this.orderDAO.getOrdersByUser(userid);
	}
	
	
	@Override
	@Transactional
	public List<Order> getOrders() {
		return this.orderDAO.getOrders();
	}
	
	@Override
	@Transactional
	public int getOrderByUserId(long userid) {
		return this.orderDAO.getOrderByUserId(userid);
	}
	
	@Override
	@Transactional
	public int createOrders(Order order) {
		return this.orderDAO.createOrder(order);
	}

	@Override
	@Transactional
	public int deleteOrderById(long orderId) {
		return this.orderDAO.cancelOrder(orderId);
	}

	@Override
	@Transactional
	public int updateOrder(Order order) {
		return this.orderDAO.updateOrder(order);
	}
}
