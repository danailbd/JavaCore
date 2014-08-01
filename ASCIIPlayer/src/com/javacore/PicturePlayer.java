package com.javacore;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PicturePlayer extends com.javacore.FilePlayer {

	public PicturePlayer() {
		super();
	}
	
	public PicturePlayer(int consoleWidth, int hIndex) {
		super(consoleWidth, hIndex);
	}
	
	@Override
	public void play() throws IOException{
		BufferedImage picture = ImageIO.read(file);
		System.out.println(this.getASCII_Image(picture));
	}

}
