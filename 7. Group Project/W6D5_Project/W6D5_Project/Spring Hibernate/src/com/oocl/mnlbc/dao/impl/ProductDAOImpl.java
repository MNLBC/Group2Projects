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


	public int addProduct(Product p) {
		// Session session = this.sessionFactory.getCurrentSession();
		// session.persist(p);
		// logger.info("Product saved successfully, Product details=" + p);
		return 1;
	}

	public List<Product> listProduct() {
		List<Product> productList = new ArrayList<Product>();
		productList = manager.createQuery("Select products From Product products", Product.class)
				.getResultList();
		for (Product p : productList) {
			logger.info("Product List::" + p);
		}
		return productList;
	}

	public int updateProduct(Product p) {
		// Session session = this.sessionFactory.getCurrentSession();
		// session.update(p);
		// logger.info("Product updated successfully, Product details" + p);
		return 1;
	}


	public List<Product> getProductByCategory(String cat) {
		return null;
		// Session session = this.sessionFactory.getCurrentSession();
		// String sql = "FROM Product WHERE PRODCAT = '" + cat + "'";
		// List<Product> productList = session.createQuery(sql).list();
		// for (Product p : productList) {
		// logger.info("Product List::" + p);
		// }
		// return productList;
	}

	
	public int removeProduct(int prodId) {
		// Session session = this.sessionFactory.getCurrentSession();
		// Product p = (Product) session.load(Product.class, new
		// Integer(prodId));
		// if (null != p) {
		// session.delete(p);
		// }
		// logger.info("Product deleted successfully!=" + p);
		return 1;
	}

}
