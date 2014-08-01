package com.javacore;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public abstract class FilePlayer{

	public int consoleWidth = 100;
	public int hIndex = 2; // sets height reduce index of a pixel
	public File file;

	public FilePlayer() {
	}
	
	public FilePlayer(int consoleWidth, int hIndex) {
		if (consoleWidth > 0 && consoleWidth < 800){
			this.consoleWidth = consoleWidth;
		}
		if (hIndex >= 0	&& hIndex < 10){
			this.hIndex = hIndex;
		}
	}
	
	
	/**
	 * Loads a file to the player
	 * @param fileToPlay - file to load to the player
	 */
	public void read(String fileToPlay) {
		file = new File(fileToPlay);
	}
	
	
	private int averageIntensityOfBlock(int x, int y, BufferedImage image) {

		int avgInten = 0, count = 0;

		for (int i = 0; i < ratio(image) + hIndex; ++i) {
			for (int j = 0; j < ratio(image); ++j) {

				Color color = new Color(image.getRGB((int) (ratio(image) * x)
						+ j, i + (int) (ratio(image) + hIndex) * y), false);
				int intensity = (color.getBlue() + color.getGreen() + color
						.getRed()) / 3;
				avgInten += intensity;
				count++;
			}
		}

		return avgInten / count;
	}

	private int getResHeightOfImage(Image image) {
		return (int) (((BufferedImage) image).getTileHeight() / (ratio(image) + hIndex));
	}

	private int getResWidthOfImage(Image image) {
		return (int) (((BufferedImage) image).getTileWidth() / ratio(image));
	}

	/**
	 * Determines what symbol to be printed for the given block of pixels
	 * @param rowsOfPixels
	 * @param intensity - intensity of the pixel block
	 * @return - String
	 */
	private String determinePixelSymbol(int intensity) {
		
		String result = null;
		
		if (intensity > 240) {
			result = " ";
		} else if (intensity > 200) {
			result = ".";
		} else if (intensity > 160) {
			result = "^";
		} else if (intensity > 120) {
			result = "*";
		} else if (intensity > 90) {
			result = "&";
		} else if (intensity > 50) {
			result = "%";
		} else if (intensity > 30) {
			result = "$";
		} else if (intensity > 20) {
			result = "@";
		} else if (intensity >= 0) {
			result = "#";
		}
		
		return result;
	}
	
	private double ratio(Image image) {
		return ((BufferedImage) image).getTileWidth() / consoleWidth;
	}
	
	/**
	 * Makes a ASCII image out of a buffered image
	 * @param image
	 * @return String
	 */
	public String getASCII_Image(BufferedImage image) {

		StringBuffer asciiImage = new StringBuffer();
		for (int i = 0; i < getResHeightOfImage(image); ++i) {

			for (int j = 0; j < getResWidthOfImage(image); ++j) {

				int intensity = averageIntensityOfBlock(j, i, image);

				asciiImage.append(determinePixelSymbol(intensity));
			}

			asciiImage.append(System.lineSeparator());
		}
		
		return asciiImage.toString();
	}

	
	
	public abstract void play() throws IOException;
}
