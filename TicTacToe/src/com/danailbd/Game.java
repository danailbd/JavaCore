package com.danailbd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	enum GameState {
		PLAYING, DRAW, X_WON, Y_WON, EXIT
	}

	enum Player_Symbol {
		X, O, EMPTY
	}
	Board board = new Board();

	private File file;

	private final short boardSize = 3;
	private Player_Symbol currentPlayer;
	private GameState currentState;
	Board boards;

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

	/**
	 * Checks if the current player has won
	 *
	 */
	public boolean hasWon(int x, int y) {
		String curBoard = board.getCurruntBoard();


		for(int i = 0 ; i<3 ; ++i)
		{
			if(curBoard.charAt(i*boardSize) == curBoard.charAt(boardSize*i + 1) &&
					curBoard.charAt(i*boardSize) == curBoard.charAt(boardSize*i + 2)) {

				return true;
			}

			if(curBoard.charAt(i) == curBoard.charAt(boardSize + i) &&
					curBoard.charAt(i) == curBoard.charAt(boardSize*2 + i)) {

				return true;
			}
		}

		if (curBoard.charAt(0) == curBoard.charAt(boardSize + 1)
				&& curBoard.charAt(0) == curBoard.charAt(boardSize * 2 + 2)
				|| curBoard.charAt(2) == curBoard.charAt(boardSize + 1)
				&& curBoard.charAt(2) == curBoard.charAt(boardSize * 2)) {
			return true;
		}

		return false;
	}

	private void isExit() {
		if(!printState()) {
			System.out.println("Exit game");
		}
	}


	public void load(String filepath){
		try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

			board = new Board(reader.readLine());
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	private void makeMove(int x, int y) {
		board.getCurruntBoard();
		boolean validInput = false;
		do {

		} while (!validInput);
	}

	private boolean printState() {
		for (GameState state : GameState.values()) {
			System.out.println(state);
		}
		return true;
	}

	// loads the file in memory before execution

	public void save(String filepath) throws IOException {
		board.toFile(filepath);
	}
}
