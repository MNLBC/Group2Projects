package com.oocl.mnlbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Client thread
 * @author FLAMEZI2
 *
 */
class ReadBooking extends Thread {

   private Socket socket;

   public ReadBooking(Socket socket) {
      this.socket = socket;
   }

   /**
    * Run method for client thread. Gets client input
    */
   public void run() {
      BufferedReader reader = null;
      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         String message = null;
         while (true) {
            System.out.println("Enter number of tickets: ");
            message = reader.readLine();
            if (message.equals("bye")) {
               System.exit(0);
               break;
            }
            System.out.println(message);

         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            if (reader != null) {
               reader.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

}