package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Client class
 * @author Danna
 *
 */
public class ChatClient {

   private String ipAdd;

   /**
    * Constructor
    * @param ipAdd
    */
   public ChatClient(String ipAdd) {
      this.ipAdd = ipAdd;
   }

   /**
    * Start client threads
    * @throws UnknownHostException
    * @throws IOException
    */
   public void startWork() throws UnknownHostException, IOException {
      Socket socket = new Socket(ipAdd, 7777);
      new ReadMessage(socket).start();
      new SendMessage(socket).start();

   }

   /**
    * Main method to create client instance and call startWork
    * @param args
    * @throws UnknownHostException
    * @throws IOException
    */
   public static void main(String[] args) throws UnknownHostException, IOException {
      ChatClient chatClient = new ChatClient(args[0]);
      chatClient.startWork();
   }

}