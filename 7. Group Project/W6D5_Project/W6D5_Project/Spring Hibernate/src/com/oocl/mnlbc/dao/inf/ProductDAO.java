package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.dao.abstr.GenericCRUD;
import com.oocl.mnlbc.model.Product;

public interface ProductDAO extends GenericCRUD<Product> {

	public List<Product> listProduct();

	public List<Product> getProductByCategory(String category);

}
