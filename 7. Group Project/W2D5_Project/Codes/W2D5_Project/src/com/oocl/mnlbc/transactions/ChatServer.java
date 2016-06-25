package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * Server class
 * 
 * @author Danna
 *
 */
public class ChatServer {

   ServerSocket serverSocket;
   List<Socket> socketList = new ArrayList<Socket>();
   List<Client> clientList = new ArrayList<Client>();
   private Client client;
   private int count = 0;
   Socket socket = null;
   Timestamp timestamp;
   Session session;

   /**
    * method to start server
    * 
    * @throws IOException
    */
   @SuppressWarnings("resource")
   public void startWork() throws IOException {
      serverSocket = new ServerSocket(7777);
      while (true) {
         socket = serverSocket.accept();
         //long sessid = DatabaseTransactions.getActiveSessionID();
         count++;
         clientList = DatabaseTransactions.getOnlineUsers();
         if (clientList.size() > 1) {
               session = new Session((long) 0, timestamp.getTimestamp(), "");
                DatabaseTransactions.createSession(session);
         }
         System.out.println(count + " client" + (count > 1 ? "s" : "") + " connected to the server.");
         socketList.add(socket);
         int index=0;
         for (int i=0; i < socketList.size(); i ++){
            if (socketList.get(i)==socket){
            index=i;
         }        
         new Chat(count, socket, socketList, clientList.get(index), clientList).run();
      }
   }
 }
   /**
    * Main method that creates server instance and starts it
    * 
    * @param args
    * @throws IOException
    */
   public ChatServer(Client client) throws IOException {
      this.client = client;

   }

   public void StartServer() throws IOException {
      System.out.println("Server started!");
      this.startWork();
   }
}