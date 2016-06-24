package com.oocl.mnlbc.transactions;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * Server class
 * 
 * @author Danna
 *
 */
public class ChatServer {

	ServerSocket serverSocket;
	List<Socket> socketList = new ArrayList<Socket>();
	List<Client> clientList = new ArrayList<Client>();
	private Client client;	
	private int count = 0;
	Socket socket = null;
	Timestamp timestamp;
	Session session;

	/**
	 * method to start server
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void startWork() throws IOException {
		serverSocket = new ServerSocket(7777);
		while (true) {
			socket = serverSocket.accept();
			long sessid = DatabaseTransactions.getActiveSessionID();
			count++;
			clientList.add(client);
			if (count > 1) {
				if (sessid == 0) {
					session = new Session(0L, clientList, timestamp.getTimestamp());
				//	DatabaseTransactions.createSession(session);
				} //else
				//	DatabaseTransactions.updateActiveSession(clientList);
			}
			// Session s = new Session
			// clients.setCount(clients.getCount() + 1);
			System.out.println(count + " client" + (count > 1 ? "s" : "") + " connected to the server.");
			socketList.add(socket);
			new Chat(count, socket, socketList, client, session).run();
			
			
		}
	}

	/**
	 * Main method that creates server instance and starts it
	 * 
	 * @param args
	 * @throws IOException
	 */
	public void ChatServer(Client client) throws IOException {
		this.client = client;

	}

	public void StartServer() throws IOException {
		this.startWork();
	}

}