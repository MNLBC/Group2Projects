package com.oocl.mnlbc.dao;

import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.User;

public interface OrdersDAO {
	public int createOrder(Order o);
	public int cancelOrder(int id);
	public int finalOrder(Order order, String timestamp);
	public Order getOrderId(User user);
}
