package com.javacore;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NotSupportedFormatException {

		if (args.length == 0) {
			System.out.println("At least path needed");
		}
		
		int consoleWidth=0, hIndex=0, playSpeed=0;
		
		if (args.length == 2) {
			consoleWidth = Integer.parseInt(args[1]);
		}
		
		if (args.length == 3) {
			hIndex = Integer.parseInt(args[2]);
		}
		
		if (args.length == 4) {
			playSpeed = Integer.parseInt(args[3]);
		}

		FilePlayer fileToPlay = null;

		fileToPlay = loadApropreatPlayer(args, consoleWidth, hIndex, playSpeed, fileToPlay);

		try {
			fileToPlay.play();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End ...");
	}
	
	
	private static FilePlayer loadApropreatPlayer(String[] args, int consoleWidth,
			int hIndex, int playSpeed, FilePlayer fileToPlay)
			throws NotSupportedFormatException {
		if (args[0].endsWith(".gif")) {
			fileToPlay = new GifPlayer(consoleWidth, hIndex, playSpeed);
			fileToPlay.read(args[0]);
		}
		else if(args[0].endsWith(".png") ||
				args[0].endsWith(".jpg")  ){

			fileToPlay = new PicturePlayer(consoleWidth, hIndex);
			fileToPlay.read(args[0]);
		}
		else if(args[0].endsWith(".mp4")){

			fileToPlay = new VideoPlayer(consoleWidth, hIndex, playSpeed);
			fileToPlay.read(args[0]);
		} else {
			throw new NotSupportedFormatException("Not supported file format");
		}
		return fileToPlay;
	}
}
