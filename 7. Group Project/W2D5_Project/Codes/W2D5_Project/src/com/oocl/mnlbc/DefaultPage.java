package com.oocl.mnlbc;

import java.io.IOException;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.transactions.ChatClient;
import com.oocl.mnlbc.transactions.DatabaseTransactions;
import com.oocl.mnlbc.transactions.LoginClient;
import com.oocl.mnlbc.transactions.RegisterClient;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * Default Page
 * @author Kassandra
 * @date 2016-06-25
 */
public class DefaultPage {

   public static Client client;

   /**
    * Main method
    * @param args
    * @throws IOException
    */
   public static void main(String[] args) throws IOException {
      displayDefaultPage();
   }

   /**
    * Method to display default page
    * @return
    * @throws IOException
    */
   @SuppressWarnings("resource")
   public static Client displayDefaultPage() throws IOException {

      Scanner scanner = new Scanner(System.in);
      boolean validChoice = false;

      RegisterClient form1 = new RegisterClient();
      LoginClient form2 = new LoginClient();

      System.out.println("----------------------------------------------------------------------");
      System.out.println("----------------------W E L C O M E----------------------");
      System.out.println("----------------------------------------------------------------------");

      while (!validChoice) {
         System.out.print("\nChoose:\n [1] Register [2] Log-In  [3] Log-In anonymously : ");
         String choice = scanner.next();

         if (choice.equals("1")) {
            form1.signUp();
            validChoice = true;
         } else if (choice.equals("2")) {
            form2.login();
            validChoice = true;
         } else if (choice.equals("3")) {
            Session session = new Session(0l, "", "");
            client = new Client("", "", "", "Stranger", "");
            if (DatabaseTransactions.getOnlineUsers().size() > 0) {
               session.setSessionId(DatabaseTransactions.getActiveSessionID());
            } else {
               DatabaseTransactions.createSession(Timestamp.getTimestamp());
            }
            ChatClient cc = new ChatClient("127.0.0.1", client, session);
            cc.connectClient();
            validChoice = true;
         } else {
            System.out.println("Please select the right choice");
         }
      }
      return client;
   }
}
