package com.javacore;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jline.ConsoleReader;


public class GifPlayer extends com.javacore.SequencePlayer {

	private List<BufferedImage> frames = null;
	
	public GifPlayer() {
		super();
	}
	
	public GifPlayer(int consoleWidth, int hIndex) {
		super(consoleWidth, hIndex);
	}
	
	public GifPlayer(int consoleWidth, int hIndex, int playSpeed) {
		super(consoleWidth, hIndex, playSpeed);
	}

	private List<BufferedImage> decodeImage() throws FileNotFoundException{
		GifDecoder gif = new GifDecoder();
		gif.read(new FileInputStream(file));
		int n = gif.getFrameCount();
		
		List<BufferedImage> frames = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			frames.add(gif.getFrame(i));  // frame i
		}
		return frames;
	}

	@Override
	public void play() throws IOException {
		frames = decodeImage();
		for(BufferedImage frame: frames){
			new ConsoleReader().clearScreen();
			
			System.out.println(getASCII_Image(frame));
			try {
				Thread.sleep(playSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

	
}