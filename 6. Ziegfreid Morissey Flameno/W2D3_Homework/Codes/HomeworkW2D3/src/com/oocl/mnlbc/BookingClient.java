package com.oocl.mnlbc;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Client class
 * @author FLAMEZI2
 *
 */
public class BookingClient {

   private String ipAdd;

   /**
    * Constructor
    * @param ipAdd
    */
   public BookingClient(String ipAdd) {
      this.ipAdd = ipAdd;
   }

   /**
    * Start client threads
    * @throws UnknownHostException
    * @throws IOException
    */
   public void startWork() throws UnknownHostException, IOException {
      Socket socket = new Socket(ipAdd, 7777);
      new ReadBooking(socket).start();
      new SendBooking(socket).start();

   }

   /**
    * Main method to create client instance and call startWork
    * @param args
    * @throws UnknownHostException
    * @throws IOException
    */
   public static void main(String[] args) throws UnknownHostException, IOException {
      BookingClient chatClient = new BookingClient(args[0]);
      chatClient.startWork();
   }

}