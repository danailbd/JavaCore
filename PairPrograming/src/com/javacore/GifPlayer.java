package com.javacore;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GifPlayer extends com.javacore.FilePlayer {
	 private GifDecoder decoder;
	 private int lastFrameIndex;
	 
	public GifPlayer(String fileToPlay) {
		super(fileToPlay);
		this.decoder = new GifDecoder();
	    this.lastFrameIndex = 0;

	}

	@Override
	public void play(String[] args) {
		// TODO Auto-generated method stub
		
	}


    @Override
    protected BufferedImage getNextFrame() {
        BufferedImage frame = decoder.getFrame(lastFrameIndex);
        lastFrameIndex++;
        return frame;
    }

	
	

}
