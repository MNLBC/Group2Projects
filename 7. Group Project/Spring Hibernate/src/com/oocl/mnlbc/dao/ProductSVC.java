package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface ProductSVC {
	public void addProduct(Product p);

	public void updateProduct(Product p);

	public List<Product> getProducts();

	public List<Product> getProductsByCategory(String category);

	public void removeProduct(int id);

	// public int updateStock(String[] array);
	// public Product getProduct(String id);
}
