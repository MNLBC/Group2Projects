package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;

public interface OrdersSVC {
	public int cancelOrder(Order order);

	public int createOrder(long userid, List<CartProduct> cartProductList);

	public List<Order> getOrdersByUser(long userid);

	public int getOrderByUserId(long userid);

	public int createOrders(Order order);

	public List<Order> getOrders();

	public int deleteOrderById(long orderId);

	public int updateOrder(Order order);
}
