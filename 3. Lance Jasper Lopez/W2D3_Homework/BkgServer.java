package com.oocl.lopezla;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BkgServer {

	class Ticket {
		private int count = 0;

		public Ticket(int count) {
			this.count = count;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}

	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(7879);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		Ticket ticketsHolder = new Ticket(500);
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println(count + " client connected to the server!");
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			new Bkg(count, socket, socketList, ticketsHolder).start();
		}
	}

	public static void main(String[] args) throws IOException {
		BkgServer bkgserver = new BkgServer();
		bkgserver.startWork();
	}

}
