package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.User;

public interface OrdersSVC {
	public int cancelOrder(Order order);
//	public int finalOrder(Order order, String timestamp);
//	public Order getOrderId(User user);
   public int createOrder(long userid, List<OrderProduct> orderproductlist);
   public List<Order> getOrdersByUser(long userid);
}
