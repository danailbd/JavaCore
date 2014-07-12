package com.danailbd;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class Game {
	enum GameState {
		PLAYING, DRAW, X_WON, Y_WON
	}

	enum Player_Symbol {
		X, O, EMPTY
	}
	Board board = new Board();

	private File file;

	private Player_Symbol currentPlayer;
	private GameState currentState;
	Board[][] boards;

	public boolean Draw() {
		board.getCurruntBoard();
		String text = "symbol";
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (text.charAt(i + j) == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private void isExit() {
		if(!printState()) {
			System.out.println("Exit game");
		}
	}

	public char isWon(char symbol) {
		board.getCurruntBoard();
		
		String text = " ";

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				
				if (text.charAt(3 * i + 0) == text.charAt(3 * i + 1)
						&& text.charAt(3 * i + 1) == text.charAt(3 * i + 2)) {
					return text.charAt(3 + i + 0);
				}
				if (text.charAt(0 + 3 * j) == text.charAt(1 + 3 * j)
						&& text.charAt(1 + 3 * j) == text.charAt(2 + 3 * j)) {
					return text.charAt(0 + 3 * j);
				}
				if (text.charAt(0 + 0) == text.charAt(1 + 1)
						&& text.charAt(1 + 1) == text.charAt(2 + 2)) {
					return text.charAt(0 + 0);
				}
				if (text.charAt(0 + 2) == text.charAt(1 + 1)
						&& text.charAt(1 + 1) == text.charAt(2 + 0)) {
					return text.charAt(0 + 2);
				}
			}
		}
	}
	private void makeMove(char symbol) {
		board.getCurruntBoard();
		
	}

	private boolean printState() {
		for (GameState state : GameState.values()) {
			System.out.println(state);
		}
		return true;
	}
	public void save(String filepath, String text) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filepath));
			writer.write(text);
		} catch (IOException e) {
			
		}
		finally {
			try {
				if(writer != null)
					writer.close();
			} catch(IOException e) {
				
			}
		}
	}
	
	// loads the file in memory before execution
	
	public int[] load(String filepath) throws FileNotFoundException {
		int memory[] = new int[100];
		try {
			File file = new File(filepath);
			FileInputStream f = new FileInputStream(file);
			DataInputStream d = new DataInputStream(f);
			for (int i=0; i<memory.length; ++i) {
				memory[i] = d.readInt();
			}
			d.readInt();
			d.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
