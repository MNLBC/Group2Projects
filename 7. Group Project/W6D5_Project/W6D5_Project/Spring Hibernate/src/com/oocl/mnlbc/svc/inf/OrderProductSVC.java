package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;

public interface OrderProductSVC {
	public int addProduct(Order order,Product prod,int qty);
//	public int removeProduct(String orderId, String productId, int qty);
	public List<Product> getRelatedProducts(Order order);
	public List<CartProduct> getCartProducts(String orderId);
	public int updateProduct(String orderId, String productId, int qty);
}
