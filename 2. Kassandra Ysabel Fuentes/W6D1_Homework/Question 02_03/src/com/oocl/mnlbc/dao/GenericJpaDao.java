package com.oocl.mnlbc.dao;
import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.oocl.mnlbc.dao.IGenericDao;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericJpaDao< T extends Serializable >
 extends AbstractJpaDao< T > implements IGenericDao< T >{

	@Override
	public T findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}
   //
}