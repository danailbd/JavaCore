package com.danailbd;

import java.io.File;

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

	public char isWon() {
		board.getCurruntBoard();
		String text = "symbol";

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

	public void load(String filepath) {

	}
	private void makeMove(char symbol) {


	}

	private boolean printState() {
		for (GameState state : GameState.values()) {
			System.out.println(state);
		}
		return true;
	}
	public void save(String filepath) {

	}
}
