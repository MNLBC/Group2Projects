package com.oocl.mnlbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.abstr.GenericCRUDImpl;
import com.oocl.mnlbc.dao.inf.ProductDAO;
import com.oocl.mnlbc.model.Product;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc Migration from Hibernate to JPA DAO Implementation for PRODUCT TABLE
 * @since 07/21/2016
 */

/**
 * 
 * @author Lance Jasper Lopez
 * @since 07/27/2016
 * @desc JPA Query Modification to prevent SQL Injection
 *
 */

@Repository
@Transactional
public class ProductDAOImpl extends GenericCRUDImpl<Product> implements ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Override
	public List<Product> listProduct() {

		List<Product> productList = new ArrayList<Product>();
		String query = "Select products From Product products";
		productList = this.entityManager.createQuery(query, Product.class).getResultList();
		for (Product product : productList) {
			logger.info("Product List:" + product);
		}
		return productList;
	}

	@Override
	public List<Product> getProductByCategory(String category) {

		String sql = "Select products From Product products where products.prodCat = :category";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter("category", category);
		List<Product> productList = query.getResultList();
		for (Product product : productList) {
			logger.info("Product List:" + product);
		}
		return productList;
	}

}
