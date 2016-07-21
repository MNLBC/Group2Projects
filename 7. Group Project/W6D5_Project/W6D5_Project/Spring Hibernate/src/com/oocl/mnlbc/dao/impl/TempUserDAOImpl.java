package com.oocl.mnlbc.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.model.User;

public class TempUserDAOImpl {
	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }
	
	public List<User> getBlacklist(EntityManager em){
		Query query = em.createNativeQuery("SELECT * FROM USERS WHERE USERTYPE = 'BLACKLIST'");
		List<Object[]> resultList = query.getResultList();
    	List<User> userList = new ArrayList<User>();
    	for(int i = 0; i < resultList.size(); i++){
    		User result = new User();
    		BigDecimal d = (BigDecimal) resultList.get(i)[0];
    		result.setUserId(d.longValue());
    		result.setUserFname((String)resultList.get(i)[1]);
    		result.setUserLname((String)resultList.get(i)[2]);
    		result.setUserEmail((String)resultList.get(i)[3]);
    		result.setUserPass((String)resultList.get(i)[4]);
    		result.setUserAddress1((String)resultList.get(i)[5]);
    		result.setUserAddress2((String)resultList.get(i)[6]);
    		result.setUserCity((String)resultList.get(i)[7]);
    		result.setUserSp((String)resultList.get(i)[8]);
    		result.setUserCountry((String)resultList.get(i)[9]);
    		result.setUserType((String)resultList.get(i)[10]);
    		userList.add(result);
    	}
    	
    	return userList;
	}
}
