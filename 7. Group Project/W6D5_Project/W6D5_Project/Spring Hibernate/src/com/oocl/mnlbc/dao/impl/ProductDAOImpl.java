package com.oocl.mnlbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

		String sql = "Select products From Product products where product.prodCat = '" + category + "'";
		List<Product> productList = this.entityManager.createQuery(sql).getResultList();
		for (Product product : productList) {
			logger.info("Product List:" + product);
		}
		return productList;
	}

}
