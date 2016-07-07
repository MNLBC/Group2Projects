package com.oocl.mnlbc.utils;

import java.sql.Connection;

public interface ProductDAO {
	private Connection getConn();
	public List<Product> getProducts();
	public int updateStock(Product product, int newStock);
}
