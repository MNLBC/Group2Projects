package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;

public class LoginClient {

   public static String userName;
   public static String userPassword;
   private Client client;

   public void login() throws IOException {
      int choice;
      RegisterClient register = new RegisterClient();
      Scanner scanner = new Scanner(System.in);

      System.out.println("-------------------------User Log-In-------------------------");

      System.out.print("Username: ");
      userName = scanner.nextLine();

      System.out.print("Password: ");
      userPassword = scanner.nextLine();

      System.out.println("Validating account...");

      if (DatabaseTransactions.getChatUser(userName, userPassword) == null) {
         System.out.println("Account is invalid. Please log-in again.");
         System.out.print("For users who have not registered yet: enter '0'. To continue: enter '1'");
         choice = scanner.nextInt();

         if (choice == 0) {
            register.signUp();
         } else if (choice == 1) {
            login();
         }
      }
      else {
         client = DatabaseTransactions.getChatUser(userName, userPassword);
         ChatServer cs = new ChatServer(client); 
         cs.startWork();
         ChatClient cc = new ChatClient("127.0.0.1", client);
         cc.connectClient();
      }
   }

}
