package com.oocl.mnlbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client thread
 * @author FLAMEZI2
 *
 */
class SendBooking extends Thread {

   private Socket socket;

   public SendBooking(Socket socket) {
      this.socket = socket;
   }

   /**
    * Run method for client thread. Sends what user has inputed
    */
   public void run() {
      BufferedReader input = null;
      PrintWriter writer = null;
      try {
         input = new BufferedReader(new InputStreamReader(System.in));
         writer = new PrintWriter(socket.getOutputStream());
         String message = null;
         while (true) {
            message = input.readLine();
            if (message.equals("bye")) {
               System.exit(0);
               break;
            }
            writer.println(message);
            writer.flush();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (input != null) {
            try {
               input.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (writer != null) {
            writer.close();
         }
      }
   }
}
