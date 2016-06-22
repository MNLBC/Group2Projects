package com.oocl.mnlbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookingServer {

   class Tickets {
      private int remaining;
      
      public Tickets(int remaining) {
         this.remaining = remaining;
      }
      
      public int getRemaining() {
         return remaining;
      }

      public void setRemaining(int remaining) {
         this.remaining = remaining;
      }
   }

   @SuppressWarnings("resource")
   public void startWork() throws IOException {
      ServerSocket serverSocket = new ServerSocket(7777);
      List<Socket> socketList = new ArrayList<Socket>();
      Tickets tickets = new Tickets(500);
      Socket socket = null;
      int count = 0;
      while (true) {
         socket = serverSocket.accept();
         count++;
         System.out.println(count + " client" + (count > 1 ? "s" : "") + " connected to the server.");
         socketList.add(socket);
         new Booking(tickets, count, socket, socketList).start();
      }
   }

   public static void main(String args[]) throws IOException {
      BookingServer chatServer = new BookingServer();
      chatServer.startWork();
   }

}