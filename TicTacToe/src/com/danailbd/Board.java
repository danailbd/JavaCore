package com.danailbd;

import java.awt.Point;

class Board {
	private String board = "   \n   \n   ";

	public Board() {
	}

	/**
	 * Constructs a new <code>Board</code> out of a String - load from file
	 *
	 */
	public Board(String _board) {
		if(board.endsWith("\n")){
			board = _board.substring(0, board.length());
		}
		board = _board;
	}

	/**
	 * Adds the given symbol('X', 'O') to the board if cell not taken
	 *
	 */
	public void addSymbol(char symbol, Point point)
			throws CellAlreadyTakeException, IndexOutOfBoundsException {
		
		if (board.charAt(4*point.x + point.y) != ' ') {
			throw new CellAlreadyTakeException(point.x, point.y);
		}
		
		StringBuilder tempBoard = new StringBuilder(board);
		tempBoard.setCharAt(4*point.x + point.y, symbol);
		board = tempBoard.toString();
	}

	/**
	 * Returns the current condition of the board, in a string
	 *
	 *@return - String (O O
	 *					XOX
	 *					   )
	 */
	public String getCurruntBoard() {
		
		return board;
	}

}
