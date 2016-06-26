package com.oocl.mnlbc.transactions;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.DatabaseTransactions;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * 
 * @author Kassandra
 * @date 2016-06-25
 *
 */
public class LoginClient {

   public static String userName;
   public static String userPassword;
   private Client client;

   /**
    * Method for login client
    * @throws IOException
    */
   @SuppressWarnings("resource")
   public void login() throws IOException {
      int choice;
      RegisterClient register = new RegisterClient();
      Scanner scanner = new Scanner(System.in);
      Console console = System.console();

      System.out.println("-------------------------User Log-In-------------------------");

      System.out.print("Username: ");
      userName = scanner.nextLine();

      System.out.print("Password: ");
      userPassword = scanner.nextLine();

      // Using console
      // char[] password = console.readPassword("Password: ");
      //
      // StringBuilder strBuilder = new StringBuilder();
      // for (int i = 0; i < password.length; i++) {
      // strBuilder.append(password[i]);
      // }
      // userPassword = strBuilder.toString();
      // Arrays.fill(password, ' ');

      System.out.println("Validating account...");

      if (userName.equals("admin") && userPassword.equals("admin")) {
         System.out.println("Starting server...");
         ChatServer cs = new ChatServer(client);
         cs.StartServer();
      } else if (DatabaseTransactions.getChatUser(userName, userPassword) == null) {
         System.out.println("Account is invalid. Please log-in again.");
         System.out.print("For users who have not registered yet: enter '0'. To continue: enter '1'");
         choice = scanner.nextInt();
         if (choice == 0) {
            register.signUp();
         } else if (choice == 1) {
            login();
         }
      } else {
         client = DatabaseTransactions.getChatUser(userName, userPassword);
         Session session = new Session(0l, "", "");
         if (DatabaseTransactions.getOnlineUsers().size() > 0) {
            session.setSessionId(DatabaseTransactions.getActiveSessionID());
         } else {
            DatabaseTransactions.createSession(Timestamp.getTimestamp());
         }
         DatabaseTransactions.declareOnline(client, Timestamp.getTimestamp());
         ChatClient cc = new ChatClient("127.0.0.1", client, session);
         cc.connectClient();
      }
   }
   
   /**
    * 
    * Method to test Login
    * @param uName
    * @param uPassword
    * @return
    */
   public boolean testLogin(String uName, String uPassword) {
      this.userName=uName;
      this.userPassword=uPassword;
      boolean success;
      
      if (DatabaseTransactions.getChatUser(uName, uPassword) != null) {
         success = true;
      }else {
         success = false;
      }
      return success;
   }

}
