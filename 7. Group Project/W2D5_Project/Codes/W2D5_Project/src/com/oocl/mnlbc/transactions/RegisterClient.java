package com.oocl.mnlbc.transactions;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import com.oocl.mnlbc.DefaultPage;
import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.utils.DatabaseTransactions;

/**
 * 
 * @author Kassandra
 * @date 2016-06-25
 */
public class RegisterClient {

   public static String firstName;
   public static String lastName;
   public static String userName;
   public static String userPassword;
   public static boolean success;
   private Client client;

   /**
    * Method for signup client
    * @throws IOException
    */
   @SuppressWarnings({ "resource", "unused" })
   public void signUp() throws IOException {
      Scanner scanner = new Scanner(System.in);
      LoginClient form3 = new LoginClient();
      Console console = System.console();
      System.out.println("---------------------Registration Form---------------------");

      System.out.print("First Name: ");
      firstName = scanner.nextLine();

      System.out.print("Last Name: ");
      lastName = scanner.nextLine();

      System.out.print("Username: ");
      userName = scanner.nextLine();

      System.out.print("Password: ");
      userPassword = scanner.nextLine();

      // Using console
      // char [] password = console.readPassword("Password: ");
      //
      // StringBuilder strBuilder = new StringBuilder();
      // for (int i = 0; i < password.length; i++) {
      // strBuilder.append(password[i]);
      // }
      // userPassword = strBuilder.toString();
      // Arrays.fill(password,' ');

      if ((firstName.equals("")) || (lastName.equals("")) || (userName.equals("")) || (userPassword.equals(""))) {
         System.out.println("Please fill all fields");
         signUp();
      } else {
         if (DatabaseTransactions.verifyChatUser(userName) == false) {
            DatabaseTransactions.createUser(new Client(userName, userPassword, firstName, lastName));
            success = true;
            System.out.println("Registration successful!");
            DefaultPage dp = new DefaultPage();
            dp.displayDefaultPage();
         } else {
            System.out.println("Username taken. Please choose another");
            signUp();
            success = false;
         }
      }
      // Go to chat
      // client = DatabaseTransactions.getChatUser(userName, userPassword);
      // ChatServer cs = new ChatServer(client);
      // cs.startWork();
      // ChatClient cc = new ChatClient("127.0.0.1", client);
      // cc.connectClient();

   }
   
   /**
    * 
    * Method for jUnit
    * @param fName
    * @param lName
    * @param uName
    * @param uPass
    * @return
    */
   public boolean testSignUp(String fName, String lName, String uName, String uPass) {
      this.firstName=fName;
      this.lastName=lName;
      this.userName=uName;
      this.userPassword=uPass;
      
      if (DatabaseTransactions.verifyChatUser(userName) == false) {
         DatabaseTransactions.createUser(new Client(userName, userPassword, firstName, lastName));
         success = true;
      } else {
         success = false;
      }
      return success;
   }
}
