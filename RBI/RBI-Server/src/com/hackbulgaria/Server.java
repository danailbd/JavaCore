package com.hackbulgaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT = 5000;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT);

		System.out.println("Server started at port " + PORT);

		BufferedReader istream = null;
		PrintWriter ostream = null;
		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();

				istream = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				String message = istream.readLine();

				ostream = new PrintWriter(clientSocket.getOutputStream(), true);

				System.out.println("Client: " + message);
				ostream.println("Server: " + message);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
