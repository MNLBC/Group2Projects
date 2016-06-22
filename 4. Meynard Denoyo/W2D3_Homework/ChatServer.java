package w2d3hw;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

   class Ticket{
      private int count = 0;

      public Ticket(int count){
         this.count = count;
      }
      
      public int getCount() {
         return count;
      }

      
      public void setCount(int count) {
         this.count = count;
      }
   }
	/**
	 * Description
	 * 
	 * @param args
	 */
	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2000);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		Ticket t = new Ticket(500);
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println(count + " clinet connected to the server!");
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			new Chat(count, socket, socketList, t).start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		ChatServer chatServer = new ChatServer();
		chatServer.startWork();
	}

}