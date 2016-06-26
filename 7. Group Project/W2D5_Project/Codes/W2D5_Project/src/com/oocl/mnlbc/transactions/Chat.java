package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.utils.DatabaseTransactions;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * Chat
 * 
 * @author LOPEZLA
 *
 *         06-24-2016
 */
public class Chat extends Thread {

   private Socket socket;
   private List<Socket> socketList;
   private int count;
   private Client client;
   private List<Client> presClients;
   private Map<String, Integer> clientSocketMap;

   public Chat(int count, Socket socket, List<Socket> socketList, Client client, List<Client> clientList,
      Map<String, Integer> clientSocketMap) {
      this.count = count;
      this.socket = socket;
      this.socketList = socketList;
      this.client = client;
      this.presClients = clientList;
      this.clientSocketMap = clientSocketMap;

   }

   public synchronized void run() {
      BufferedReader reader = null;
      PrintWriter writer = null;
      String presClientName = "";
      String presUsername = "";
      String screenName = "";

      presClientName = this.client.getFname() + " " + this.client.getLname();
      presUsername = this.client.getUsername();
      screenName = presClientName + " <" + presUsername + ">";

      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         // writer = new PrintWriter(socket.getOutputStream());
         // writer.println(screenName + " is now in the room.");
         // writer.flush();

         for (int i = 0; i < socketList.size(); i++) {
            writer = new PrintWriter(socketList.get(i).getOutputStream());
            writer.println(screenName + " is now in the room.");
            writer.flush();
         }

         Date date = new Date();
         // static session id still for change
         long presClientId = Long.parseLong(this.client.getId());

         while (true) {
            Message message = new Message(1L, 1L, presClientId, screenName, date.toString());
            message.setMessage("");
            message.setMessage(reader.readLine().trim());

            // Client will quit if client send "bye", and print "bye" to in
            // the client
            if (message.getMessage().equals("-bye")) {
               DatabaseTransactions.declareOffline(client, Timestamp.getTimestamp());
               clientSocketMap.remove(client.getId());
               writer = new PrintWriter(socket.getOutputStream());
               writer.println("Closing");
               writer.flush();
               // System.exit(0);
               // continue;

            } else if (message.getMessage().equals("-list")) {
               List<Client> clients = DatabaseTransactions.getOnlineUsers();
               for (Client client : clients) {
                  writer = new PrintWriter(socket.getOutputStream());
                  writer
                     .println(client.getUsername() + ":" + client.getFname() + " " + client.getLname() + " is online");
                  writer.flush();
               }

            } else {
               // Print all the message to all clients, Group chat
               for (int i = 0; i < socketList.size(); i++) {
                  writer = new PrintWriter(socketList.get(i).getOutputStream());
                  writer.println(screenName + " says: " + message.getMessage());
                  writer.flush();
               }
            }

         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
