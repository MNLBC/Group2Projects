package com.oocl.mnlbc.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.mapping.List;

public abstract class AbstractJpaDao< T extends Serializable > {
 
   private Class< T > clazz;
 
   @PersistenceContext
   EntityManager entityManager;
 
   public void setClazz( Class< T > clazzToSet ){
      this.clazz = clazzToSet;
   }
 
   public T findOne( Long id ){
      return entityManager.find( clazz, id );
   }
  
 
   public void save( T entity ){
      entityManager.persist( entity );
   }
 
   public void update( T entity ){
      entityManager.merge( entity );
   }
 
   public void delete( T entity ){
      entityManager.remove( entity );
   }
 
}