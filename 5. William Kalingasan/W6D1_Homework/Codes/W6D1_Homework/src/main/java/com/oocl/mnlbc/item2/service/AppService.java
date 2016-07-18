package com.oocl.mnlbc.item2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppService {

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
    
    public int getOrderDetails(EntityManager em) {
    	try{
    		Query query = em.createNativeQuery("SELECT A.USERFULLNAME, B.ORDER_DESC, C.ORDERITEM__DESC "
        			+ "FROM W6D1_USER A, W6D1_ORDER B, W6D1_ORDERITEM C WHERE A.USERNAME = B.USERNAME "
        			+ "AND B.ORDER_ID = C.ORDER_ID AND A.USERNAME = 'williuum'");
        	List<Object[]> result = query.getResultList();
        	System.out.println("\nNAME\t\tORDER DESC\t\tITEM");
        	for(Object[] rec : result){
        		System.out.println(rec[0] + "\t" + rec[1] + "\t" + rec[2]);
        	}
        	return 1;
    	}
    	catch(Exception e){
    		return 0;
    	}
    	
    }
}
