package com.oocl.mnlbc.item1.jpa;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.item1.service.StudentTeacherService;

public class Item1 {

	public static void main(String[] args){
		StudentTeacherService stService = new StudentTeacherService();
		stService.init();
		EntityManager em = stService.getEntityManager();
		stService.getTeacherAverage(em);
		em.close();
	}
}
