package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.entity.Item;

/**
 * Item Service to get item info
 * 
 * @author flamezi2
 * @since 2016-07-19
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

   public Item getItemInfo(EntityManager em, String id) {
      Item item = em.find(Item.class, id);
      return item;
   }

   @SuppressWarnings("unchecked")
   public List<Item> getAllItemInfo(EntityManager em) {
      Query query = em.createNativeQuery("select * from items");
      return query.getResultList();
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }
}
