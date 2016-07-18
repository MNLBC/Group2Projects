package edu.javacourse.jpa;

import edu.javacourse.jpa.entity.Teacher;
import edu.javacourse.jpa.service.TeacherService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class SimpleExample {

    public static void main(String[] args) {
        TeacherService rs = new TeacherService();
        rs.init();
        EntityManager em = rs.getEntityManager();
       
        	 Teacher teacher = rs.getTeacher(em, 1);
       
        em.close();
    }

}
