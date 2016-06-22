package com.oocl.mnlbc;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BookingClient {

   private String ipAdress;

   public BookingClient(String ipAdress) {
      this.ipAdress = ipAdress;
   }

   public void startWork() throws UnknownHostException, IOException {
      Socket socket = new Socket(ipAdress, 7777);
      new ReadBooking(socket).start();
      new SendBooking(socket).start();

   }

   public static void main(String[] args) throws UnknownHostException, IOException {
      BookingClient chatClient = new BookingClient(args[0]);
      chatClient.startWork();
   }

}