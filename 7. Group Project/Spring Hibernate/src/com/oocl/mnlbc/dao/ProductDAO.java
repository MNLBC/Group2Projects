package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface ProductDAO {

	public void addProduct(Product p);

	public void updateProduct(Product p);

	public List<Product> listProduct();

	public List<Product> getProductByCategory(String cat);

	public void removeProduct(int id);

}
