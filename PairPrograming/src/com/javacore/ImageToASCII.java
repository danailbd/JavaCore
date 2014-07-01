package com.javacore;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class ImageToASCII {

	private final static int consoleSize= 125;

	public static int averageIntensityOfBlock(int x, int y, BufferedImage image) {

		int avgInten = 0, count = 0;
		int heigthRatio = image.getTileHeight() / getResHeightOfImage(image);

		for (int i = 0; i < ratio(image); ++i) {
			for (int j = 0; j < heigthRatio; ++j) {

				Color color = new Color(image.getRGB(ratio(image) * x + j, i
						+ heigthRatio * y), false);
				int intensity = (color.getBlue() + color.getGreen() + color
						.getRed()) / 3;
				avgInten += intensity;
				count++;
			}
		}

		return avgInten / count;
	}

	public static int getResHeightOfImage(Image image) {
		return ((BufferedImage) image).getTileHeight() / ratio(image);
	}

	public static int getResWidthOfImage(Image image) {
		return ((BufferedImage) image).getTileWidth() / ratio(image);
	}

	public static void main(String[] args) {

		Path pathToImage = Paths.get(args[0]);
		BufferedImage image = null;
		try {
			image = ImageIO.read(pathToImage.toFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer rowOfPixels = new StringBuffer();
		for (int i = 0; i < getResHeightOfImage(image); ++i) {

			for (int j = 0; j < getResWidthOfImage(image); ++j) {

				int intensity = averageIntensityOfBlock(j, i, image);

				if (intensity > 240) {
					rowOfPixels.append(" ");
				} else if (intensity > 200) {
					rowOfPixels.append(".");
				} else if (intensity > 160) {
					rowOfPixels.append("^");
				} else if (intensity > 120) {
					rowOfPixels.append("*");
				} else if (intensity > 80) {
					rowOfPixels.append("@");
				} else if (intensity > 40) {
					rowOfPixels.append("#");
				} else if (intensity > 0) {
					rowOfPixels.append("&");
				}
			}

			rowOfPixels.append(System.lineSeparator());
		}
		System.out.println(rowOfPixels.toString());
	}

	private static int ratio(Image image){
		return ((BufferedImage) image).getTileWidth()/consoleSize;
	}
}
