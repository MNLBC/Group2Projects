package com.oocl.mnlbc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.model.Product;

public class ProductDAOImpl implements ProductDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	@Override
	public Product getProductById(EntityManager entity, String Id) {
		// TODO Auto-generated method stub
		Product product = entity.find(Product.class, Id);
		return product;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
