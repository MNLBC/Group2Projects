package com.oocl.mnlbc.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Item;

/**
 * @author fuentka
 * @since 07/19/2016
 */
public class ItemService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public Item getItem(EntityManager em, String id) {
		Item item = em.find(Item.class, id);
		return item;
	}

	public List<Item> getItems() {
		entityManager.getTransaction().begin();
		List<Item> listItems = entityManager.createQuery("SELECT i FROM Item i").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return listItems;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
