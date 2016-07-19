package com.oocl.mnlbc.Service;

import java.util.List;

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
   
   public List<Item> getItemsById(String id){
      String sql = "SELECT i FROM Item i WHERE i.id = :id";
      return entityManager.createQuery(sql).setParameter("id", id).getResultList();
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }
}
