package com.oocl.mnlbc.svc.inf;

import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.User;

public interface OrdersSVC {
	public int createOrder(Order order);
	public int cancelOrder(Order order);
//	public int finalOrder(Order order, String timestamp);
//	public Order getOrderId(User user);
}
