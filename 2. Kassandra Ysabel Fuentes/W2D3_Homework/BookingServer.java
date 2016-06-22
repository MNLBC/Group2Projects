package com.oocl.mnlbc.homework.w2.d3.v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookingServer {

   class Tickets{
      private int originalTicket;
      
      public Tickets(int getTicket)
      {
         this.originalTicket=getTicket;
      }
   }
	
      public int getOriginalTicket() {
         return originalTicket;
      }

      
      public void setOriginalTicket(int originalTicket) {
         this.originalTicket = originalTicket;
      }

   /**
	 * Description
	 * 
	 * @param args
	 */
	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
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
			new Booking(ticket, count, socket, socketList).start();
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