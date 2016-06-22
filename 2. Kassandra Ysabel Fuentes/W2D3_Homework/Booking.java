package com.oocl.mnlbc.homework.w2.d3.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 	
 */
class Booking extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	private int tickets;

	public Booking(int tickets, int count, Socket socket, List<Socket> socketList) {
		this.tickets = tickets;
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
	}

	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String message = null;
			while (true) {
				message = reader.readLine();
				// Client will quit if client send "bye", and print "bye" to in the client

				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}if (Integer.parseInt(message) < 500) {
				   writer.println("Tickets ordered is more than 500");
				}

            int remainingTickets = this.tickets;
            remainingTickets = this.tickets-Integer.parseInt(message);
				// Print all the message to all clients, Group chat
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					writer.println(remainingTickets + " tickets left");
					writer.flush();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}