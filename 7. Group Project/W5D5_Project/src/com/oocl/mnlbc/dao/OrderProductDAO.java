package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.bean.CartProduct;
import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.Product;

public interface OrderProductDAO {
	public int addProduct(Order order,Product prod,int qty);
	public int removeProduct(String orderId, String productId, int qty);
	public List<Product> getRelatedProducts(Order order);
	public List<CartProduct> getCartProducts(String orderId);
	public int updateProduct(String orderId, String productId, int qty);
}
