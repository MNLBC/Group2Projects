package WK2D3Homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage extends Thread{
	private Socket socket;
	private int ticket;
	
	public SendMessage(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader input = null;
		PrintWriter writer = null;
		try {
			System.out.println("Hello dear customer, how many tickets do you want to buy?");
			input = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream());
			String message = null;
			while (true) {
				message = input.readLine();
				if (message.equals("quit")) {
					break;
				}
				writer.println(message);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
}
