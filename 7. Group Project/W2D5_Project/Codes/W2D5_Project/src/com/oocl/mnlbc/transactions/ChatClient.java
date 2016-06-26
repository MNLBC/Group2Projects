package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.FileTransactions;

/**
 * Client class
 * 
 * @author Danna
 * @since 2016-06-25
 */
public class ChatClient {

   private String ipAdd;
   private Client client;
   private Session session;

   /**
    * Constructor
    * 
    * @param ipAdd
    */
   public ChatClient(String ipAdd, Client client, Session sesh) {
      this.ipAdd = ipAdd;
      this.client = client;
      this.session = sesh;
   }

   /**
    * Start client threads
    * 
    * @throws UnknownHostException
    * @throws IOException
    */
   public void startWork() throws UnknownHostException, IOException {
      Socket socket = new Socket(ipAdd, Integer.parseInt(FileTransactions.getConfigValue("port")));
      // Socket socket = new Socket(ipAdd, 7777);
      // DatabaseTransactions.declareOnline(client, Timestamp.getTimestamp());
      new ReadMessage(socket, client, session).start();
      new SendMessage(socket, client, session).start();

   }

   /**
    * Main method to create client instance and call startWork
    * 
    * @throws UnknownHostException
    * @throws IOException
    */
   // public void main(String[] args) throws UnknownHostException, IOException {
   // ChatClient chatClient = new ChatClient(args[0]);
   // chatClient.startWork();
   // }
   public void connectClient() throws UnknownHostException, IOException {
      System.out.println("Successfully logged in!");
      System.out.println("====================\n");
      System.out.println("====================");
      System.out.println("Welcome! " + client.getFname() + " " + client.getLname());
      System.out.println("====================\n");
      this.startWork();
   }
}