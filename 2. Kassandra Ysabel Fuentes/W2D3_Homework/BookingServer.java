package com.oocl.mnlbc.homework.w2.d3.v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


class Ticket {
   private int originalTicket;
   
   Ticket(int value)
   {
     this.originalTicket=value;
   }
    
   public int getOriginalTicket() {
      return originalTicket;
   }

   
   public int setOriginalTicket(int originalTicket) {
      this.originalTicket = originalTicket;
      return originalTicket;
   }

}

public class BookingServer {

   /**
	 * Description
	 * 
	 * @param args
	 */
	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
		Ticket tickets = new Ticket(500);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		int count = 0;
		
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println(count + " client connected to the server!");
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			new Booking(tickets, count, socket, socketList).start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BookingServer chatServer = new BookingServer();
		chatServer.startWork();
	}

}