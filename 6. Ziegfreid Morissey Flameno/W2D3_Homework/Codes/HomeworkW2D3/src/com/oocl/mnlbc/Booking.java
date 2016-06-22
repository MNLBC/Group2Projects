package com.oocl.mnlbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.oocl.mnlbc.BookingServer.Tickets;

/**
 * 	
 */
class Booking extends Thread {

   private Socket socket;
   private List<Socket> socketList;
   private int count;
   private Tickets tickets;

   public Booking(Tickets tickets, int count, Socket socket, List<Socket> socketList) {
      this.tickets = tickets;
      this.count = count;
      this.socket = socket;
      this.socketList = socketList;
   }

   public synchronized void run() {
      BufferedReader reader = null;
      PrintWriter writer = null;
      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         String message = null;
         while (true) {
            message = reader.readLine();
            if (message.equals("bye")) {
               writer = new PrintWriter(socket.getOutputStream());
               writer.println("bye");
               writer.flush();
               System.exit(0);
               continue;
            }

            this.tickets.setRemaining(this.tickets.getRemaining() - Integer.parseInt(message));
            for (int i = 0; i < socketList.size(); i++) {
               writer = new PrintWriter(socketList.get(i).getOutputStream());
               writer.println("Tickets left: " + this.tickets.getRemaining() + " tickets");
               writer.flush();
            }

         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }
}