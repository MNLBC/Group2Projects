package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.Order;

public interface OrdersDAO {
	public int createOrder(Order order);

	public List<Order> getOrdersByUser(long userId);

	public int cancelOrder(long id);
	
	public int getOrderByUserId(long userId);

	public boolean isPremium(long userId);

	public List<Order> getOrders();
	
	public int updateOrder(Order order);

	public int deleteOrderById(long orderId);

}
