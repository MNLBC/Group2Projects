package com.oocl.mnlbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * Server class
 * @author FLAMEZI2
 *
 */
public class BookingServer {
   
   /**
    * Inner class tickets to hold number of tickets
    * @author FLAMEZI2
    *
    */
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

   /**
    * Inner class clients to hold number of clients
    * @author FLAMEZI2
    *
    */
   class Clients {

      private int count = 0;

      public int getCount() {
         return count;
      }

      public void setCount(int count) {
         this.count = count;
      }
   }

   /**
    * method to start server
    * @throws IOException
    */
   @SuppressWarnings("resource")
   public void startWork() throws IOException {
      ServerSocket serverSocket = new ServerSocket(7777);
      List<Socket> socketList = new ArrayList<Socket>();
      Tickets tickets = new Tickets(500);
      Clients clients = new Clients();
      Socket socket = null;
      while (true) {
         socket = serverSocket.accept();
         clients.setCount(clients.getCount() + 1);
         System.out.println(
            clients.getCount() + " client" + (clients.getCount() > 1 ? "s" : "") + " connected to the server.");
         socketList.add(socket);
         new Booking(tickets, clients, socket, socketList).start();
      }
   }

   /**
    * Main method that creates server instance and starts it
    * @param args
    * @throws IOException
    */
   public static void main(String args[]) throws IOException {
      BookingServer chatServer = new BookingServer();
      chatServer.startWork();
   }

}