package w2d3hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import w2d3hw.ChatServer.Ticket;

/**
 * 	
 */
class Chat extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	private Ticket tickets;

	public Chat(int count, Socket socket, List<Socket> socketList, Ticket t) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
		this.tickets = t;
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
				}
//				
            this.tickets.setCount(this.tickets.getCount() - Integer.parseInt(message));
				// Print all the message to all clients, Group chat
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					writer.println("Remaining Tickets " + this.tickets.getCount());
					writer.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}