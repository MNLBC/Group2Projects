package com.oocl.lopezla;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.oocl.lopezla.BkgServer.Ticket;



public class Bkg extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;

	private Ticket tickets;
	
	public Bkg(int count, Socket socket, List<Socket> socketList, Ticket tick) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
		this.tickets = tick;
		
	}
	
	public synchronized void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String message = null;
			beforeInput:
			while (true) {
				message = null;
				message = reader.readLine().trim();
				
				// Client will quit if client send "bye", and print "bye" to in the client
				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}
				try{
					int ticketsOrdered = Integer.parseInt(message);
						if(this.tickets.getCount() >= ticketsOrdered){
						this.tickets.setCount(this.tickets.getCount() - ticketsOrdered);
						}
						else{
							writer = new PrintWriter(socket.getOutputStream());
							writer.println("Not enough tickets.");
							writer.flush();
							continue beforeInput;
						}
					}
					catch(Exception e){
						writer = new PrintWriter(socket.getOutputStream());
						writer.println("Wrong input");
						writer.flush();
						
						continue beforeInput;
					}
				
			

				// Print all the message to all clients, Group chat
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					writer.println("Tickets left :"+ this.tickets.getCount());
					writer.flush();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
