package com.oocl.lopezla;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;






public class BkgClient {

	private String ipAddress;

	public BkgClient(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public void startWork() throws UnknownHostException, IOException {
		Socket socket = new Socket(ipAddress, 7879);
		new ReadTicket(socket).start();
		new SendTicket(socket).start();

		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		BkgClient bkgClient = new BkgClient(args[0]);
		bkgClient.startWork();
	}

}
