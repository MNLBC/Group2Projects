package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.utils.Timestamp;
/**
 * ReadMessage class
 * 
 * @author denoyme
 *
 */
public class ReadMessage extends Thread {

   private Socket socket;
   private Client client;

   public ReadMessage(Socket socket, Client client) {
      this.socket = socket;
      this.client = client;
   }

   public void run() {
      BufferedReader reader = null;
      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         String message = null;
         while (true) {
            message = reader.readLine();
            
            if (message.equals("bye")) {
               DatabaseTransactions.declareOffline(client, Timestamp.getTimestamp());
               break;
            }
         }
      } catch (IOException e) {
         System.out.println(client.getUsername() + " has left");
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
