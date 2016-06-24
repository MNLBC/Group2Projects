package com.oocl.mnlbc;

import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.transactions.DatabaseTransactions;

public class RegisterClient {

   public static String firstName;
   public static String lastName;
   public static String userName;
   public static String userPassword;

   @SuppressWarnings("resource")
   public void  signUp() {
      Scanner scanner = new Scanner(System.in);
      LoginClient form3 = new LoginClient();
      System.out.println("---------------------Registration Form---------------------");

      System.out.print("First Name: ");
      firstName = scanner.nextLine();

      System.out.print("Last Name: ");
      lastName = scanner.nextLine();

      System.out.print("Username: ");
      userName = scanner.nextLine();

      System.out.print("Password: ");
      userPassword = scanner.nextLine();
      
      while ((firstName.equals("")) || (lastName.equals("")) || (userName.equals("")) || (userPassword.equals(""))){
         System.out.println("Please fill all fields");
         signUp();
      }
         DatabaseTransactions.createUser(new Client(userName, userPassword, firstName, lastName));
         System.out.println("Registration successful!");
   }
}
