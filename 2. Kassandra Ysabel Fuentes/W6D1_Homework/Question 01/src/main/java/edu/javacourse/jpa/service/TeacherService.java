package edu.javacourse.jpa.service;

import edu.javacourse.jpa.entity.Student;
import edu.javacourse.jpa.entity.Teacher;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }

    public  Teacher getTeacher(EntityManager em, Integer id) {
        Teacher teacher = em.find(Teacher.class, id);
        return teacher;
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
