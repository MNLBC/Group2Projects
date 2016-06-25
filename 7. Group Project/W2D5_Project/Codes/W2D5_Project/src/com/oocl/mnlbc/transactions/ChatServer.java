package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   Map<String, Integer> clientSocketMap = new HashMap<String, Integer>();

   /**
    * method to start server
    * 
    * @throws IOException
    */
   public void startWork() throws IOException {
//      serverSocket = new ServerSocket(Integer.parseInt(FileTransactions.getPort()));
      serverSocket = new ServerSocket(7777);
      while (true) {
         socket = serverSocket.accept();
         // long sessid = DatabaseTransactions.getActiveSessionID();
         count++;
         clientList = DatabaseTransactions.getOnlineUsers();
         if (clientList.size() == 2) {
            session = new Session((long) 0, Timestamp.getTimestamp(), "");
            DatabaseTransactions.createSession(Timestamp.getTimestamp());
         }
         System.out.println(count + " client" + (count > 1 ? "s" : "") + " connected to the server.");
         socketList.add(socket);
         
         for (int i = 0; i < socketList.size(); i++) {
           System.out.println("Testing:" + socketList.get(i));
          }
         int temp = socketList.size()-1;
         String clientId = clientList.get(temp).getId();
         int listsize = socketList.size();
         clientSocketMap.put(clientId, listsize);
         int index = 0;
         for (int i = 0; i < socketList.size(); i++) {
            if (socketList.get(i) == socket) {
               index = i;
            }
         }
            System.out.println("Count:" + count);
            System.out.println("Socket" + socket);
            System.out.println("clientlist: " +clientList.get(index));
            new Chat(count, socket, socketList, clientList.get(index), clientList, clientSocketMap).start();
         
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