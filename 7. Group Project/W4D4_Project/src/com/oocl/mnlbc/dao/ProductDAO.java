package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.bean.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	public int updateStock(Product product, int newStock);
}
