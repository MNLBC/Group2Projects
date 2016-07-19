package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Item;

public class ItemService {

	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());
        
    }
    
    public Item getItemById(String itemId) {
    	EntityManager em = entityManager;
        Item item = em.find(Item.class, itemId);
        return item;
     }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
	

