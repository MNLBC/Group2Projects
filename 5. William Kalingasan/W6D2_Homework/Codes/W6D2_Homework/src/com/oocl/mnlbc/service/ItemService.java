package com.oocl.mnlbc.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.entity.Item;

public class ItemService {

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
	
	public Item getItemById(EntityManager em, int itemId){
		Query query = em.createNativeQuery("SELECT * FROM W6D2_ITEM WHERE ITEM_ID = '" + itemId + "'");
    	List<Object[]> resultList = query.getResultList();
    	Item result = new Item();
    	for(Object[] rec : resultList){
    		result.setItemId((String)rec[0]);
    		result.setItemName((String)rec[1]);
    		result.setItemCategory((String)rec[2]);
    		BigDecimal d = (BigDecimal) rec[3];
    		result.setItemStock(d.intValue());
    		d = (BigDecimal) rec[4];
    		result.setItemPrice(d.doubleValue());
    	}
    	return result;
	}
}
