package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;

public interface OrderProductDAO {
	public int addOrderProduct(OrderProduct op);
	public int removeOrderProduct(int id);
	public List<Product> getRelatedProducts(Order order);
	public List<CartProduct> getCartProducts(String orderId);
	public int updateOrderProduct(OrderProduct op);
}
