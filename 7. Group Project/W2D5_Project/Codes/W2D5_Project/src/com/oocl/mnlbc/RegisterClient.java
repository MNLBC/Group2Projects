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
   public static boolean success;
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
      
      if (success=true){
         System.out.println("Registration successful!");
      }
         
   }
}
