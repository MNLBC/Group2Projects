package com.oocl.mnlbc.dao.inf;

import com.oocl.mnlbc.model.Order;

public interface OrdersDAO {
	public int createOrder(Order order);

	public int cancelOrder(long id);

}
