package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.oocl.mnlbc.models.Client;

public class SendMessage extends Thread{
   
   private Socket socket;
//   private Client client;
   
   public SendMessage(Socket socket){
      this.socket = socket;
//      this.client = client;
   }
   
   public void run(){
      BufferedReader input = null;
      PrintWriter writer = null;
      try {
         input = new BufferedReader(new InputStreamReader(System.in));
         writer = new PrintWriter(socket.getOutputStream());
         String message = null;
         while (true) {
            message = input.readLine();
            if (message.equals("bye")) {
               break;
            }
            writer.println(message);
            writer.flush();
         }
      } catch (IOException e) {
//         System.out.println(client.getUsername() + " has left");
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
