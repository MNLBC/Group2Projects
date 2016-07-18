package com.oocl.mnlbc.dao;

import java.io.Serializable;

import org.hibernate.mapping.List;

public interface IGenericDao<T extends Serializable> {
	 
	   T findOne(final long id);
	 
	   void create(final T entity);
	 
	   T update(final T entity);
	 
	   void delete(final T entity);

	}