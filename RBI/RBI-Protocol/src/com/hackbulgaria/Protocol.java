package com.hackbulgaria;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Protocol {
	
	private static final String EOM = "<[EOM]>";
	public static final int PORT = 3000;
	

    public static String readRBImessage(Socket clientSocket) throws IOException {
        InputStream socketInput = clientSocket.getInputStream();
        Scanner sc = new Scanner(socketInput);

        String line = "";
        StringBuilder builder = new StringBuilder();
        while (!line.contains(EOM)) {
            line = sc.nextLine();
            builder.append(line);
        }

        sc.close();
        return builder.toString();
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
