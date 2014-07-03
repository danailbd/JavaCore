package com.javacore;

import java.io.File;

public abstract class FilePlayer implements com.javacore.Player {

	public int consoleSize = 100;
	public int hIndex = 2; // sets height reduce index of a pixel
	public File file;

	public FilePlayer(String fileToPlay) {
		file = new File(fileToPlay);
	}

	@Override
	public abstract void play(String[] args);
}
