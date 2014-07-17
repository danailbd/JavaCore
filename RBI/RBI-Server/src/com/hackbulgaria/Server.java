package com.hackbulgaria;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(Protocol.PORT);
		Socket clientSocket = null;

		System.out.println("Server started at Protocol.PORT " + Protocol.PORT);

		while (true) {
			try {
				clientSocket = serverSocket.accept();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		while (true) {
			
		}
	}
}
