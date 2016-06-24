package com.oocl.mnlbc;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oocl.mnlbc.models.Client;

public class DefaultPage {

   public static Client client;

   @SuppressWarnings("resource")
   public static void main(String[] args) throws IOException {

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
            // enter chat
            client.setUsername("stranger");
            validChoice = true;
         } else {
            System.out.println("Please select the right choice");
         }
      }
   }

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
            // enter chat
            validChoice = true;
         } else {
            System.out.println("Please select the right choice");
         }
      }
      return client;
   }
}
