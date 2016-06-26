package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.DatabaseTransactions;
import com.oocl.mnlbc.utils.FileTransactions;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * Server class
 * 
 * @author Danna
 *
 */
public class ChatServer {

   ServerSocket serverSocket;
   List<Client> clientList = new ArrayList<Client>();
   private Client client;
   private int count = 0;
   Socket socket = null;
   Timestamp timestamp;
   Session session;
   protected Map<String, Integer> clientSocketMap = new HashMap<String, Integer>();

   class SocketList {

      private List<Socket> socketList;

      public SocketList() {
         this.socketList = new ArrayList<Socket>();
      }

      public void addSocket(Socket socket) {
         socketList.add(socket);
      }

      public void removeSocket(int index) {
         socketList.remove(index);
      }

      public List<Socket> getSocketList() {
         return socketList;
      }

      public void setSocketList(List<Socket> socketList) {
         this.socketList = socketList;
      }

   }

   /**
    * method to start server
    * 
    * @throws IOException
    */
   public void startWork() throws IOException {
      serverSocket = new ServerSocket(Integer.parseInt(FileTransactions.getConfigValue("port")));
      SocketList socketList = new SocketList();
      // serverSocket = new ServerSocket(7777);
      while (true) {
         socket = serverSocket.accept();
         // long sessid = DatabaseTransactions.getActiveSessionID();
         count++;
         clientList = DatabaseTransactions.getOnlineUsers();
         if (clientList.size() == 2) {
            session = new Session((long) 0, Timestamp.getTimestamp(), "");
            DatabaseTransactions.createSession(Timestamp.getTimestamp());
         }
         System.out
            .println(clientList.size() + " client" + (clientList.size() > 1 ? "s" : "") + " connected to the server.");
         socketList.addSocket(socket);

         for (int i = 0; i < socketList.getSocketList().size(); i++) {
            System.out.println("Testing:" + socketList.getSocketList().get(i));
         }
         // int temp = socketList.getSocketList().size() - 1;
         String clientId = clientList.get(clientList.size() - 1).getId();
         int listsize = socketList.getSocketList().size();
         clientSocketMap.put(clientId, listsize);
         // int index = 0;
         // for (int i = 0; i < socketList.getSocketList().size(); i++) {
         // if (socketList.getSocketList().get(i) == socket) {
         // index = i;
         // }
         // }
         // System.out.println("Count:" + count);
         // System.out.println("Socket" + socket);
         // System.out.println("clientlist: " + clientList.get(index));
         new Chat(count, socket, socketList, clientList.get(clientList.size() - 1), clientList, clientSocketMap)
            .start();

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