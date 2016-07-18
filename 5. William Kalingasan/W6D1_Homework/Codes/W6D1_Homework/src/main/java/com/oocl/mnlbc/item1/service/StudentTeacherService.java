package com.oocl.mnlbc.item1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.item1.entity.Student;

public class StudentTeacherService {

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
    
    public void getTeacherAverage(EntityManager em) {
    	Query query = em.createNativeQuery("SELECT B.TEACHER_NAME, B.TEACHER_SCHOOL_NAME, AVG(A.STUDENT_SCORE) AS STUDENT_AVERAGE "
    			+ "FROM W6D1_STUDENT A, W6D1_TEACHER B WHERE A.TEACHER_ID = B.TEACHER_ID GROUP BY B.TEACHER_NAME, B.TEACHER_SCHOOL_NAME");
    	List<Object[]> result = query.getResultList();
    	System.out.println("\nTEACHER\t\tSCHOOL\t\tAVERAGE");
    	for(Object[] rec : result){
    		System.out.println(rec[0] + "\t" + rec[1] + "\t" + rec[2]);
    	}
    }
}
