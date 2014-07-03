package com.javacore;

public class Main {

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			System.out.println("At least path needed");
		}

		FilePlayer fileToPlay;

		if (args[0].endsWith(".gif")) {
			fileToPlay = new GifPlayer(args[0]);
		}
		else if(args[0].endsWith(".png") ||
				args[0].endsWith(".jpg")  ){

			fileToPlay = new PicturePlayer(args[0]);
		}
		else if(args[0].endsWith(".mp4")){

			fileToPlay = new VideoPlayer(args[0]);
		} else {
			throw new Exception("Not supported file format");
		}

		fileToPlay.play(args);
	}
}