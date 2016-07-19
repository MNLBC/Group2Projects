package com.oocl.mnlbc.service;

import java.util.ArrayList;
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
      entityManager = entityManagerFactory.createEntityManager();

   }

   public Item getItemInfo(EntityManager em, String id) {
      Item item = em.find(Item.class, id);
      return item;
   }

   public List<Item> getAllItemInfo(EntityManager em) {
      List<Item> list = new ArrayList<Item>();
      Query query = em.createQuery("select i from Item i");
      for (Object object : query.getResultList()) {
         Item item = (Item) object;
         list.add(item);
     }
      return list;
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }
}
