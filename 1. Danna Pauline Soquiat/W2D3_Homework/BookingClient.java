package WK2D3Homework;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BookingClient {
	private String ipAdd;

	public BookingClient(String ipAString) {
		this.ipAdd = ipAdd;
	}

	public void startWork() throws UnknownHostException, IOException {
		Socket socket = new Socket(ipAdd, 2345);
		new ReadMessage(socket).start();
		new SendMessage(socket).start();
		
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		BookingClient bookingClient = new BookingClient(args[0]);
		bookingClient.startWork();
	}
}
