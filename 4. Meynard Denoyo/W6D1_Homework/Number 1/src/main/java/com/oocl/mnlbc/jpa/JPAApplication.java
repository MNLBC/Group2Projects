package com.oocl.mnlbc.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Teacher;
import com.oocl.mnlbc.service.TeacherService;

public class JPAApplication {

	public static void main(String[] args) {
		
		TeacherService ts = new TeacherService();
		ts.init();
		EntityManager em = ts.getEntityManager();
		
		List<Object[]> tlist= ts.getTeachersAndAVG();
		System.out.println("TEACHER \t \t SCHOOL \t \t \t AVERAGE");
		for(Object[] t: tlist){
			System.out.println(t[0] + "\t \t"+ t[1] + " \t \t "+ t[2]);
		}
	}
}
