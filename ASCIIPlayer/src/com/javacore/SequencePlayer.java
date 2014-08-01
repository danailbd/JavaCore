package com.javacore;

import java.awt.image.BufferedImage;


public abstract class SequencePlayer extends FilePlayer {
	int playSpeed = 50;

	public SequencePlayer() {
		super();
	}

	public SequencePlayer(int consoleWidth, int hIndex) {
		super(consoleWidth, hIndex);
	}
	
	public SequencePlayer(int consoleWidth, int hIndex, int playSpeed) {
		super(consoleWidth, hIndex);
		
		if(playSpeed > 20 && playSpeed < 80){
			this.playSpeed = playSpeed;
		}
	}

	protected abstract BufferedImage getNextFrame();

}
