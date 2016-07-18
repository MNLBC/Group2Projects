package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Teacher;


/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

public class TeacherService {

	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }
    
    @SuppressWarnings("unchecked")
	public List<Teacher> getTeacherList() {
        return entityManager.createQuery("select t from Teacher t").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Object[]> getTeachersAndAVG(){
    	return entityManager.createNativeQuery("SELECT a.teacher_name, a.teacher_school_name, AVG(student_score) "
    			+ "FROM Teacher A, Student B "
    			+ "WHERE a.teacher_id = b.student_teacherid "
    			+ "GROUP BY a.TEACHER_NAME, a.TEACHER_SCHOOL_NAME").getResultList();
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
