package com.oocl.mnlbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.util.UserJDBCTemplate;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("com/oocl/mnlbc/util/beans.xml");

      UserJDBCTemplate UserJDBCTemplate = 
      (UserJDBCTemplate)context.getBean("UserJDBCTemplate");
      
      System.out.println("------Records Creation--------" );
      UserJDBCTemplate.create("Zara", 11);
      UserJDBCTemplate.create("Nuha", 2);
      UserJDBCTemplate.create("Ayan", 15);
      
      System.out.println("------Listing Multiple Records--------" );
      List<User> Users = UserJDBCTemplate.listUsers();
      for (User record : Users) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }

      System.out.println("----Updating Record with ID = 2 -----" );
      UserJDBCTemplate.update(2, 20);

      System.out.println("----Listing Record with ID = 2 -----" );
      User User = UserJDBCTemplate.getUser(2);
      System.out.print("ID : " + User.getId() );
      System.out.print(", Name : " + User.getName() );
      System.out.println(", Age : " + User.getAge());
	  
   }
}