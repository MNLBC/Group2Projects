package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface ProductSVC {
	public int addProduct(Product p);

	public int updateProduct(Product p);

	public List<Product> getProducts();

	public List<Product> getProductsByCategory(String category);

	public int removeProduct(long id);

	// public int updateStock(String[] array);
	// public Product getProduct(String id);
	
	

}
