package com.oocl.mnlbc.service;

import java.util.ArrayList;
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

	@SuppressWarnings("rawtypes")
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

	@SuppressWarnings("unchecked")
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		entityManager.getTransaction().begin();
		List result = entityManager.createQuery("SELECT p FROM Item p").getResultList();
		if (!result.isEmpty()) {
			items = (List<Item>) result;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return items;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
