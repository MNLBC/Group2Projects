package com.oocl.mnlbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oocl.mnlbc.BookingServer.Clients;
import com.oocl.mnlbc.BookingServer.Tickets;

/**
 * Server thread
 * @author FLAMEZI2
 *
 */
class Booking extends Thread {

   private Socket socket;
   private List<Socket> socketList;
   private Clients clients;
   private Tickets tickets;

   /**
    * Constructor
    * @param tickets
    * @param clients
    * @param socket
    * @param socketList
    */
   public Booking(Tickets tickets, Clients clients, Socket socket, List<Socket> socketList) {
      this.tickets = tickets;
      this.clients = clients;
      this.socket = socket;
      this.socketList = socketList;
   }

   /**
    * Run thread
    */
   public synchronized void run() {
      BufferedReader reader = null;
      PrintWriter writer = null;
      try {
         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         String message = null;
         while (true) {
            message = reader.readLine();
            //When user exits / inputs bye
            if (message.equals("bye")) {
               writer = new PrintWriter(socket.getOutputStream());
               writer.println("bye");
               clients.setCount(clients.getCount() - 1);
               writer.flush();
               continue;
            }

            //Check if user inputed number and if there is enough tickets
            Pattern p = Pattern.compile("^[0-9]+$");
            Matcher m = p.matcher(message);
            if (!m.find()) {
               writer = new PrintWriter(socket.getOutputStream());
               writer.println("Wrong input");
               writer.flush();
            } else if(this.tickets.getRemaining()<Integer.parseInt(message)){
               writer = new PrintWriter(socket.getOutputStream());
               writer.println("Not enough tickets");
               writer.flush();
            }else{
               System.out.println(message + " ticket/s was bought");
               System.out.println("Tickets left: " + this.tickets.getRemaining() + " tickets");
               this.tickets.setRemaining(this.tickets.getRemaining() - Integer.parseInt(message));
               for (int i = 0; i < socketList.size(); i++) {
                  writer = new PrintWriter(socketList.get(i).getOutputStream());
                  writer.println("Tickets left: " + this.tickets.getRemaining() + " tickets");
                  writer.flush();
               }
            }

         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}