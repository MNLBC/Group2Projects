package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.model.Teacher;

public class TeacherSVC {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Teacher listTeacherStudGrades(String TeacherId) {

		Query query = entityManager.createQuery(
				"SELECT teach FROM Teacher teach  WHERE teach.teacherId = '"
						+ TeacherId + "'");

		Teacher teacher = (Teacher) query.getSingleResult();


		return teacher;

	}
}
