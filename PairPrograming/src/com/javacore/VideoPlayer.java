package com.javacore;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class VideoPlayer extends SequencePlayer {
	
	public VideoPlayer() {
		super();
	}

	public VideoPlayer(int consoleWidth, int hIndex) {
		super(consoleWidth, hIndex);
	}
	
	public VideoPlayer(int consoleWidth, int hIndex, int playSpeed) {
		super(consoleWidth, hIndex, playSpeed);
	}

	
	@Override
	protected BufferedImage getNextFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void play() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
