package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Teacher;

/**
 * Teacher Service to get teacher info
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
public class TeacherService {

   private EntityManagerFactory entityManagerFactory;
   private EntityManager entityManager;

   @SuppressWarnings("rawtypes")
   public void init() {
      entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
      System.out.println(entityManagerFactory.getClass().getSimpleName());
      entityManager = entityManagerFactory.createEntityManager();
      System.out.println(entityManager.getClass().getSimpleName());

   }
   
   public Teacher getTeacherInfo(EntityManager em, String id) {
      Teacher teacher = em.find(Teacher.class, id);
      return teacher;
   }

   public EntityManager getEntityManager() {
      return entityManager;
   }
}
