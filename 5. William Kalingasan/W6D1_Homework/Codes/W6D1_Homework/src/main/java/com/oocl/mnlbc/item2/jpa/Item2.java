package com.oocl.mnlbc.item2.jpa;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.item2.service.AppService;

public class Item2 {
	public static void main(String[] args){
		AppService appService = new AppService();
		appService.init();
		EntityManager em = appService.getEntityManager();
		appService.getOrderDetails(em);
		em.close();
	}
}
