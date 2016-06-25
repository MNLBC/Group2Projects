package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.oocl.mnlbc.models.Client;

/**
 * Client class
 * 
 * @author Danna
 *
 */
public class ChatClient {

   private String ipAdd;
   private Client client;

   /**
    * Constructor
    * 
    * @param ipAdd
    */
   public ChatClient(String ipAdd, Client client) {
      this.ipAdd = ipAdd;
      this.client = client;
   }

   /**
    * Start client threads
    * 
    * @throws UnknownHostException
    * @throws IOException
    */
   public void startWork() throws UnknownHostException, IOException {
      Socket socket = new Socket(ipAdd, 7777);
      new ReadMessage(socket, client).start();
      new SendMessage(socket, client).start();

   }

   /**
    * Main method to create client instance and call startWork
    * 
    * @param args
    * @throws UnknownHostException
    * @throws IOException
    */
   // public void main(String[] args) throws UnknownHostException, IOException {
   // ChatClient chatClient = new ChatClient(args[0]);
   // chatClient.startWork();
   // }
   public void connectClient() throws UnknownHostException, IOException {
      this.startWork();
   }
}