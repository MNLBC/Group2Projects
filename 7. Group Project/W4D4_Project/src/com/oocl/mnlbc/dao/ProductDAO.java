package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.bean.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	public List <Product> getProductsByCategory(String category);
	public int updateStock(Product product, int qty);
	public Product getProduct(String id);
}
