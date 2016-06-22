package com.oocl.mnlbc.homework.w2.d3.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 接受服务器信息
 */
class ReadBooking extends Thread {
	private Socket socket;

	public ReadBooking(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String message = null;
		   System.out.println("Enter tickets to be purchased: ");
			while (true) {
				message = reader.readLine();
				// 当读服务器信息线程接收到bye，该线程退出
				if (message.equals("bye")) {
					break;
				}
				System.out.println(message);
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