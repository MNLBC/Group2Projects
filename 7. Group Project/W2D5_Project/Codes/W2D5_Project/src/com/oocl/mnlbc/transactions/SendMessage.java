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
import com.oocl.mnlbc.utils.Timestamp;
/**
 * SendMessage class
 * 
 * @author denoyme
 *
 */
public class SendMessage extends Thread{
   
   private Socket socket;
   private Client client;
   private Session presSesh;
   
   public SendMessage(Socket socket, Client client, Session session){
      this.socket = socket;
      this.client = client;
      this.presSesh = session;
   }
   
   public synchronized void run(){
      BufferedReader input = null;
      PrintWriter writer = null;
      try {
    	 Date date = new Date();
         input = new BufferedReader(new InputStreamReader(System.in));
         writer = new PrintWriter(socket.getOutputStream());
        
         while (true) {
        	 Message message = new Message(this.presSesh.getSessionId(), 
 					0L, Long.parseLong(this.client.getId()), null, date.toString());
        	 message.setMessage(input.readLine().trim());
            if (message.equals("-bye")) {
               break;
            }
        
            writer.println(message.getMessage());
            writer.flush();
         }
      } catch (IOException e) {
         System.out.println(client.getUsername() + " has left");
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
