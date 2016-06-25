package com.oocl.mnlbc.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;

import oracle.sql.DATE;

public class ReadMessage extends Thread {

	private Socket socket;
	private Client client;
	private Session presSesh;

	public ReadMessage(Socket socket, Client client, Session session) {
		this.socket = socket;
		this.client = client;
		this.presSesh = session;
	}

	public void run() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Date date = new Date();
			Message message = new Message(this.presSesh.getSessionId(), 
					0L, Long.parseLong(this.client.getId()), null, date.toString());
			while (true) {
				message.setMessage(reader.readLine().trim());

				if (message.equals("bye")) {
					System.out.println(client.getUsername() + " has left");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
