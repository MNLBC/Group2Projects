package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.DatabaseTransactions;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * SendMessage class
 * 
 * @author Meynard
 * @since 2016-06-25
 */
public class SendMessage extends Thread {

   private Socket socket;
   private Client client;
   private Session presSesh;

   /**
    * Constructor for SendMessage
    * 
    * @param socket
    * @param client
    * @param session
    */
   public SendMessage(Socket socket, Client client, Session session) {
      this.socket = socket;
      this.client = client;
      this.presSesh = session;
   }
   /**
    * Thread method in order to run SendMessage
    * 
    * 
    */
   public void run() {
      BufferedReader input = null;
      PrintWriter writer = null;
      try {
         Date date = new Date();
         input = new BufferedReader(new InputStreamReader(System.in));
         writer = new PrintWriter(socket.getOutputStream());

         while (true) {
            Message message = new Message(this.presSesh.getSessionId(), 0L, Long.parseLong(this.client.getId()), null,
               date.toString());
            message.setMessage(input.readLine().trim());
            if (message.getMessage().equals("-bye")) {
            	   writer.println(client.getUsername() + " has left the room");
                   writer.flush();
               break;
            }

            writer.println(message.getMessage());
            writer.flush();
         }
      } catch (IOException e) {
         System.out.println("You have logged out");
         // System.out.println(client.getUsername() + " has left");
         DatabaseTransactions.declareOffline(client, Timestamp.getTimestamp());
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
