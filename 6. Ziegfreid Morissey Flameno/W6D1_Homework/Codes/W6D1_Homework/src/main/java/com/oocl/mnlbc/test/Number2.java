package com.oocl.mnlbc.test;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Teacher;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.TeacherService;
import com.oocl.mnlbc.service.UserService;

/**
 * Run this to test app
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
public class Number2 {

   public static void main(String[] args) {
      UserService us = new UserService();
      us.init();
      EntityManager em = us.getEntityManager();

//      Scanner reader = new Scanner(System.in); // Reading from System.ins
//      System.out.print("Enter user id: ");
//      String id = reader.nextLine();

      User fromDb = us.getUserInfo(em, "1");
      System.out.println("fromDb = " + fromDb);

      em.close();
   }
}
