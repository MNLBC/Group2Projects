package com.oocl.mnlbc.utils;

public interface OrdersDAO {
	public int createOrder(long userId);
	public int cancelOrder(long orderId);
	public int finalOrder(long orderId);
}
