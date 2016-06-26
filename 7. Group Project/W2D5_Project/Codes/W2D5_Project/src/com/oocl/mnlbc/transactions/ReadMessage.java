package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;
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
   private Session presSesh;

   public ReadMessage(Socket socket, Client client, Session session) {
      this.socket = socket;
      this.client = client;
      this.presSesh = session;
   }

   public synchronized void run() {
      BufferedReader reader = null;
      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         Date date = new Date();

         while (true) {
            Message message = new Message(this.presSesh.getSessionId(), 0L, Long.parseLong(this.client.getId()), null,
               date.toString());
            message.setMessage(reader.readLine().trim());
            System.out.println(message.getMessage());
            FileTransactions.write(message, presSesh);
            if (message.equals("-bye")) {
               break;
            }
         }
      } catch (IOException e) {
         System.out.println(client.getUsername() + " has left");
         DatabaseTransactions.declareOffline(client, Timestamp.getTimestamp());
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
