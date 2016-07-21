package com.oocl.mnlbc.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public long countAll(final Map<String, Object> params) {

		final StringBuffer queryString = new StringBuffer("SELECT count(o) from ");

		queryString.append(type.getSimpleName()).append(" o ");
		queryString.append(this.getQueryClauses(params, null));

		final Query query = this.em.createQuery(queryString.toString());

		return (Long) query.getSingleResult();

	}

	private Object getQueryClauses(Map<String, Object> params, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public T create(final T t) {
		this.em.persist(t);
		return t;
	}

	public void delete(final Object id) {
		this.em.remove(this.em.getReference(type, id));
	}

	public T find(final Object id) {
		return (T) this.em.find(type, id);
	}

	public T update(final T t) {
		return this.em.merge(t);
	}

}