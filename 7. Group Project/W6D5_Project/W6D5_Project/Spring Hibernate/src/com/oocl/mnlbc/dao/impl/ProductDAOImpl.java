package com.oocl.mnlbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	@PersistenceContext
	private EntityManager manager;

	public int addProduct(Product product) {

		manager.persist(product);
		logger.info("Product saved successfully, Product details=" + product);
		return 1;
	}

	public List<Product> listProduct() {
		List<Product> productList = new ArrayList<Product>();
		String query = "Select products From Product products";
		productList = manager.createQuery(query, Product.class).getResultList();
		for (Product product : productList) {
			logger.info("Product List::" + product);
		}
		return productList;
	}

	public int updateProduct(Product product) {

		Product newProduct = manager.find(Product.class, product.getProdId());
		newProduct = product;
		logger.info("Product updated successfully!=" + newProduct);
		return 1;
	}

	public List<Product> getProductByCategory(String cat) {

		String sql = "Select products From Product products where product.PRODCAT = '" + cat + "'";
		List<Product> productList = manager.createQuery(sql).getResultList();
		for (Product product : productList) {
			logger.info("Product List:" + product);
		}
		return productList;
	}

	public int removeProduct(int prodId) {
		Product removedProduct = manager.find(Product.class, prodId);
		manager.remove(removedProduct);
		logger.info("Product deleted successfully!=" + removedProduct);
		return 1;
	}

}
