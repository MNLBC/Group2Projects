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
      System.out.println("------------------------Registration Form------------------------");

      System.out.println("First Name: ");
      firstName = scanner.nextLine();

      System.out.println("Last Name: ");
      lastName = scanner.nextLine();

      System.out.println("Username: ");
      userName = scanner.nextLine().trim();

      System.out.println("Password: ");
      userPassword = scanner.nextLine().trim();

      DatabaseTransactions.createUser(new Client(userName, userPassword, firstName, lastName));
      System.out.println("Registration successful!");
   }

}
