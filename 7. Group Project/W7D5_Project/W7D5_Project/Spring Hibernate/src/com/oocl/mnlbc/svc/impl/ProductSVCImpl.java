package com.oocl.mnlbc.svc.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.ProductDAO;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.ProductSVC;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc SVC Implementation for PRODUCT TABLE
 * @date 07-15-2016
 * 
 */

@Service
public class ProductSVCImpl implements ProductSVC {

	private ProductDAO prodDAO;

	public void setProductDAO(ProductDAO prodDAO) {
		this.prodDAO = prodDAO;
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return this.prodDAO.listProduct();
	}

	@Override
	@Transactional
	public List<Product> getProductsByCategory(String category) {
		return this.prodDAO.getProductByCategory(category);
	}

	public String countProductByCat() {
		return null;
	}

	@Override
	public boolean addProduct(Product product) {

		return this.prodDAO.add(product);
	}

	@Override
	public boolean updateProduct(Product product) {

		return this.prodDAO.update(product);
	}

	@Override
	@Transactional
	public boolean removeProduct(long id) {

		return this.prodDAO.remove(id);
	}

}