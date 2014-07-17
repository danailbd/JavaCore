package com.hackbulgaria;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Protocol {
	
	private static final String EOM = "<[EOM]>";
	public static final int PORT = 3000;
	

    public static void readRBImessage(Socket socket) {
		
	}
	
    public static void writeRBImessage(Socket socket, String message) {
    	
    	PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    	outStream.println(message + EOM);
    }
	
}
