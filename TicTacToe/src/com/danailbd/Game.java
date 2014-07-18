package com.danailbd;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Game {
	enum GameState {
		PLAYING, DRAW, X_WON, O_WON, EXIT
	}

	enum PlayerSymbol {
		X, O, EMPTY
	}

	private Board board = new Board();

	private final short boardSize = 4;
	private PlayerSymbol currentPlayer;
	private GameState currentState;

	public Game() {
		currentPlayer = PlayerSymbol.O;
		currentState = GameState.PLAYING;
	}

	public Game(String _board) {
		loadState(_board);
		currentState = GameState.PLAYING;
	}
	
	private void loadState(String _board) {
		setCurrentPlayer(_board);
		board = new Board(_board);
	}
	
	// --- Game logic ---


	public GameState makeMove(int x, int y) throws IndexOutOfBoundsException,
			CellAlreadyTakeException {
		board.addSymbol(currentPlayer.toString().charAt(0), new Point(x, y));
		if (hasWon()) {
			if (currentPlayer.equals(GameState.O_WON))
				currentState = GameState.O_WON;
			else
				currentState = GameState.X_WON;
		}

		nextPlayer();

		return currentState;
	}
	
	private void nextPlayer() {
		if (currentPlayer.equals(PlayerSymbol.O))
			currentPlayer = PlayerSymbol.X;
		else
			currentPlayer = PlayerSymbol.O;
	}

	
	
	private boolean checkLinesAndColums(String curBoard) {

		for (int i = 0; i < 3; ++i) {
			if (curBoard.charAt(i * boardSize) == curBoard.charAt(boardSize * i
					+ 1)
					&& curBoard.charAt(i * boardSize) == curBoard
							.charAt(boardSize * i + 2)) {

				return true;
			}

			if (curBoard.charAt(i) == curBoard.charAt(boardSize + i)
					&& curBoard.charAt(i) == curBoard.charAt(boardSize * 2 + i)) {

				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals(String curBoard) {
		
		boolean leftToRigh = curBoard.charAt(0) == curBoard.charAt(boardSize + 1)
				&& curBoard.charAt(0) == curBoard.charAt(boardSize * 2 + 2);
		
		boolean rightToRight = curBoard.charAt(2) == curBoard.charAt(boardSize + 1)
				&& curBoard.charAt(2) == curBoard.charAt(boardSize * 2);
		
		return (leftToRigh || rightToRight);
	}

	protected boolean hasWon() {
		String curBoard = board.getCurruntBoard();

		return checkLinesAndColums(curBoard) || checkDiagonals(curBoard);
	}

	
	// ---  Utility methods --- 
	
	public void save(String saveFile) throws FileNotFoundException,
			UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(saveFile, "ASCII");
		String curBoard = board.getCurruntBoard();
		writer.println(curBoard);

		writer.close();
	}

	
	public void load(String loadFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(loadFile));
		StringBuilder loadedBoard = new StringBuilder();
		String temp;
		while ((temp = reader.readLine()) != null) {
			loadedBoard.append(temp + System.lineSeparator());
		}

		board = new Board(loadedBoard.toString());
		reader.close();
		
		
		setCurrentPlayer(loadedBoard.toString());
		
	}

	private void setCurrentPlayer(String loadedBoard) {
		int oses = loadedBoard.length() - loadedBoard.toString().replace("O", "").length(),
			xses = loadedBoard.length() - loadedBoard.toString().replace("X", "").length();
		if(oses - xses == 0){
			currentPlayer = PlayerSymbol.O;
		}
		else{
			currentPlayer = PlayerSymbol.X;
		}
	}

	
	public String visualise() {
		return board.getCurruntBoard();
	}

	
	public void redo() {

	}

	public void undo() {

	}
}
