package com.danailbd;

import java.awt.Point;
import java.io.IOException;

public class Game {
	enum GameState {
		PLAYING, DRAW, X_WON, Y_WON, EXIT
	}

	enum PlayerSymbol {
		X, O, EMPTY
	}
	Board board = new Board();

	private PlayerSymbol currentPlayer;
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
		return 0;
	}




	public void load(String filepath) {
		board = new Board(filepath);
	}

	public GameState makeMove(int x, int y) throws CellAlreadyTakeException {
		board.addSymbol(currentPlayer.toString().charAt(0), new Point(x, y));

		return GameState.PLAYING;
	}

	public void redo() {
	}


	public void save(String filepath) throws IOException {
		board.toFile(filepath);
	}

	public void undo(){}
}

