package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.DatabaseTransactions;
import com.oocl.mnlbc.utils.FileTransactions;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * ReadMessage class
 * 
 * @author Meynard
 *
 */
public class ReadMessage extends Thread {

   private Socket socket;
   private Client client;
   private Session presSesh;

   
   /**
    * Constructor for ReadMessage
    * 
    * @param socket
    * @param client
    * @param session
    */
   public ReadMessage(Socket socket, Client client, Session session) {
      this.socket = socket;
      this.client = client;
      this.presSesh = session;
   }
   /**
    * Thread method in order to run ReadMessage
    * 
    * 
    */
   public void run() {
      BufferedReader reader = null;
      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         while (true) {
            Date date = new Date();
            Message message = new Message(DatabaseTransactions.getActiveSessionID(), 0L, Long.parseLong(this.client.getId()), null,
               date.toString());
            message.setMessage(reader.readLine().trim());
            System.out.println(message.getMessage());
            FileTransactions.write(message, DatabaseTransactions.getActiveSessionID());
            DatabaseTransactions.saveMessage(message);
            if (message.getMessage().equals("-bye")) {
               break;
            }
         }
      } catch (IOException e) {
         System.out.println("You have logged out");
         Thread.currentThread().interrupt();
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
