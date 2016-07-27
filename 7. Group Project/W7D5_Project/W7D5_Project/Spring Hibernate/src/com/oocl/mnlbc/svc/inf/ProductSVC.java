package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface ProductSVC {
	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public List<Product> getProducts();

	public List<Product> getProductsByCategory(String category);

	public boolean removeProduct(long id);

}
