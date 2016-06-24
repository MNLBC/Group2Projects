package com.oocl.mnlbc;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.transactions.Chat;
import com.oocl.mnlbc.transactions.DatabaseTransactions;

public class LoginClient {

   public static String userName;
   public static String userPassword;

   public void login() {
      int choice;
      RegisterClient register = new RegisterClient();
      Scanner scanner = new Scanner(System.in);

      System.out.println("-------------------------User Log-In-------------------------");

      System.out.println("Username: ");
      userName = scanner.next();

      System.out.println("Password: ");
      userPassword = scanner.next();

      System.out.println("Validating account...");

      if (DatabaseTransactions.getChatUser(userName, userPassword) == null) {
         System.out.println("Account is invalid. Please log-in again.");
         System.out.println("For users who have not registered yet: enter '0'. To continue: enter '1'");
         choice = scanner.nextInt();

         if (choice == 0) {
            register.signUp();
         } else if (choice == 1) {
            login();
         }
      }
      else {
         DatabaseTransactions.getChatUser(userName, userPassword);
         // MainMenu menu = new MainMenu();
      }
   }

}
