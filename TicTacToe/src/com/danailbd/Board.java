package com.danailbd;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.PrintWriter;

class Board {
	private char[][] board = new char[][] { { ' ', ' ', ' ' },
			{ ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

	/**
	 * Constructs a new <code>Board</code> out of a String - load from file
	 *
	 * @param _board
	 */
	public Board(String _board) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				board[i][j] = _board.charAt(4 * i + j);
			}
		}
	}

	/**
	 * Adds the given symbol('X', 'O') to the board if cell not taken
	 *
	 */
	public void addSymbol(char symbol, Point2D point) throws Exception {
		if (board[(int) point.getX()][(int) point.getY()] != ' ') {
			throw new Exception("Cell already taken");
		}
		board[(int) point.getX()][(int) point.getY()] = symbol;
	}

	/**
	 * Returns the current condition of the board, in a string
	 *
	 */
	public String getCurruntBoard() {

		StringBuilder _board = new StringBuilder();
		for (int i = 0; i < 3; ++i) {
			_board.append(board[i].toString());
		}
		return _board.toString();
	}

	/**
	 * Writes the current board to the given file
	 *
	 */
	public void toFile(String filePath) throws IOException {
		PrintWriter writer = new PrintWriter(filePath, "ASCII");
		for (int i = 0; i < 3; ++i) {
			writer.println(board[i].toString());
		}
		writer.close();
	}
}