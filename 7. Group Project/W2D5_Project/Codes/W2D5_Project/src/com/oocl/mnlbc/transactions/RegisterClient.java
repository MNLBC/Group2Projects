package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;

public class RegisterClient {

   public static String firstName;
   public static String lastName;
   public static String userName;
   public static String userPassword;
   public static boolean success;
   private Client client;
   @SuppressWarnings("resource")
   public void  signUp() throws IOException {
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
      
      if ((firstName.equals("")) || (lastName.equals("")) || (userName.equals("")) || (userPassword.equals(""))){
         while ((firstName.equals("")) || (lastName.equals("")) || (userName.equals("")) || (userPassword.equals(""))){
            System.out.println("Please fill all fields");
            signUp();
            success = true;
         }
      }
         else{
            if (DatabaseTransactions.verifyChatUser(userName) == false){
               DatabaseTransactions.createUser(new Client(userName, userPassword, firstName, lastName));
               success = true;
            }
            else{
               System.out.println("Username taken. Please choose another");
               signUp();
               success=false;
            }
      }
//      Go to chat
      client = DatabaseTransactions.getChatUser(userName, userPassword);
      ChatServer cs = new ChatServer(client); 
      cs.startWork();
      ChatClient cc = new ChatClient("127.0.0.1", client);
      cc.connectClient();
      
      if (success=true){
         System.out.println("Registration successful!");
      }
         
   }
}
