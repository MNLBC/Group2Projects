package com.oocl.mnlbc.item2.junit;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.item2.service.AppService;

import junit.framework.TestCase;

public class AppServiceTest extends TestCase {

	public void testGetOrderDetails() {
		AppService appService = new AppService();
		appService.init();
		EntityManager em = appService.getEntityManager();
		assert(appService.getOrderDetails(em)==1);
		em.close();
	}

}
