package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface ProductDAO {

	public int addProduct(Product p);

	public int updateProduct(Product p);

	public List<Product> listProduct();

	public List<Product> getProductByCategory(String cat);

	public int removeProduct(int id);

}
