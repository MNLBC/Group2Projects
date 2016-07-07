package com.oocl.mnlbc.utils;

public interface OrderProductDAO {
	public int addProduct(long orderId,long prodId,int qty);
	public int removeProduct(long orderProductId);
	public List<Product> getRelatedProducts(long orderId);
}
