package com.oocl.mnlbc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.model.Product;

public interface ProductDAO {
	public Product getProductById(EntityManager entity, String Id);
	public void init();
	public EntityManager getEntityManager();
}
