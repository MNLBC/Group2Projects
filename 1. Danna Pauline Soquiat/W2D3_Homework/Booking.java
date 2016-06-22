package WK2D3Homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Booking extends Thread {
	private Socket sock;
	private List<Socket> socketList;
	private int count;
	Ticket tix;
	public Booking(int count, Socket sock, List<Socket> socketList, Ticket tix) {
		this.setCount(count);
		this.sock = sock;
		this.socketList = socketList;
		this.tix=tix;
	}


	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));

			String message = null;
			while (true) {
				message = reader.readLine();
				// Client will quit if client send "quit", and print "quit" to in the client
				if (message.equals("quit")) {
					writer = new PrintWriter(sock.getOutputStream());
					writer.println("quit");
					writer.flush();
					continue;
				}
				int inputTicket= Integer.parseInt(message);
				tix.setTix(tix.getTix()-inputTicket);
				// Print all the message to all clients, Group chat
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					
					writer.println("Remaining Tickets "+ tix.getTix());
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
