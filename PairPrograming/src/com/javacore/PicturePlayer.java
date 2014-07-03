package com.javacore;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PicturePlayer extends com.javacore.FilePlayer {

	public PicturePlayer(String filePath) {
		super(filePath);
	}

	public int averageIntensityOfBlock(int x, int y, BufferedImage image) {

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

	public int getResHeightOfImage(Image image) {
		return (int) (((BufferedImage) image).getTileHeight() / (ratio(image) + hIndex));
	}

	public int getResWidthOfImage(Image image) {
		return (int) (((BufferedImage) image).getTileWidth() / ratio(image));
	}

	@Override
	public void play(String[] args) {

		if (args.length > 1) {
			if (Integer.parseInt(args[1]) > 0
					&& Integer.parseInt(args[1]) < 800) {
				consoleSize = Integer.parseInt(args[1]);
			}
		}
		if (args.length > 2) {
			if (Integer.parseInt(args[2]) >= 0
					&& Integer.parseInt(args[2]) < 10) {
				hIndex = Integer.parseInt(args[2]);
			}
		}
		BufferedImage image = null;

		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer rowsOfPixels = new StringBuffer();
		for (int i = 0; i < getResHeightOfImage(image); ++i) {

			for (int j = 0; j < getResWidthOfImage(image); ++j) {

				int intensity = averageIntensityOfBlock(j, i, image);

				if (intensity > 240) {
					rowsOfPixels.append(" ");
				} else if (intensity > 200) {
					rowsOfPixels.append(".");
				} else if (intensity > 160) {
					rowsOfPixels.append("^");
				} else if (intensity > 120) {
					rowsOfPixels.append("*");
				} else if (intensity > 90) {
					rowsOfPixels.append("&");
				} else if (intensity > 50) {
					rowsOfPixels.append("%");
				} else if (intensity > 30) {
					rowsOfPixels.append("$");
				} else if (intensity > 20) {
					rowsOfPixels.append("@");
				} else if (intensity > 0) {
					rowsOfPixels.append("#");
				}
			}

			rowsOfPixels.append(System.lineSeparator());
		}
		System.out.println(rowsOfPixels.toString());
	}

	private double ratio(Image image) {
		return ((BufferedImage) image).getTileWidth() / consoleSize;
	}
}