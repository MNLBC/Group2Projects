package com.oocl.mnlbc.utils;

import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.User;

public interface OrdersDAO {
	public int createOrder(User user);
	public int cancelOrder(Order order);
	public int finalOrder(Order order, String timestamp);
}
