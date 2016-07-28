package com.oocl.mnlbc.dao.abstr;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Lance Jasper Lopez
 * @desc GenericDAO Implementation
 * @since 07/22/2016
 */

@Repository
@Transactional
public abstract class GenericCRUDImpl<T> implements GenericCRUD<T> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public GenericCRUDImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public boolean add(T t) {
		this.entityManager.persist(t);
		return true;
	}

	@Override
	public boolean update(T t) {
		this.entityManager.merge(t);
		return true;
	}

	@Override
	public boolean remove(long id) {
		this.entityManager.remove(this.entityManager.find(entityClass, id));
		return true;
	}

}
