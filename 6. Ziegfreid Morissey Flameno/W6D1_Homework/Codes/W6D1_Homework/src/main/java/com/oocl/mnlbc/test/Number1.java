package com.oocl.mnlbc.test;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Teacher;
import com.oocl.mnlbc.service.TeacherService;

/**
 * Run this to test app
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
public class Number1 {

   public static void main(String[] args) {
      TeacherService ts = new TeacherService();
      ts.init();
      EntityManager em = ts.getEntityManager();

      Scanner reader = new Scanner(System.in); // Reading from System.in
      System.out.print("Enter teacher id: ");
      String id = reader.nextLine();

      Teacher fromDb = ts.getTeacherInfo(em, id);
      System.out.println("fromDb = " + fromDb);

      em.close();
   }
}
