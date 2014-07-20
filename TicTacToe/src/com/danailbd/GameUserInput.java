package com.danailbd;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import com.danailbd.Game.GameState;

public class GameUserInput {
	private String[] players = new String[] { "Player1", "Player2" };

	private Game gameInstance = new Game();
	private GameState gameState = null;

	private String saveFile = "gameSave"; // local dir

	public void checkUserCommand(String choise) {

		try {
			switch (choise.charAt(0)) {
			case 'n':
				runGame();
				gameState = GameState.EXIT;
			case 'l':
				gameInstance.load(saveFile);
			case 's':
				gameInstance.save(saveFile);
			case 'q':
				gameState = GameState.EXIT;
			case 'r':
				gameInstance.redo();
			case 'u':
				gameInstance.undo();
			default:
				System.out.println("Invalid opearation given");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fieldsInitialisation() {
		Game gameInstance = new Game();
		gameState = GameState.PLAYING;
	}

	public void nameInitialisation() {
		Console consoleIn = System.console();

		players[0] = consoleIn.readLine("Enter name for user 1");
		players[1] = consoleIn.readLine("Enter name for user 2");
	}

	public String printFinishGameState(GameState _gameState) {

		String result = null;
		switch (_gameState) {
		case X_WON:
			result = players[0] + " has won this game";
			break;
		case O_WON:
			result = players[1] + " has won this game";
			break;
		case DRAW:
			result = players[0] + " and " + players[1]
					+ " has finished draw this game";
			break;
		}
		return result;
	}

	// Main method for starting the game
	public void runGame() throws IOException {
		// nameInitialisation();
		fieldsInitialisation();

		boolean finishGame = false;
		
		while (finishGame == false) {
			printCurrentStatus();
			String choise = getChoise();

			int x, y;
			try {
				y = Character.getNumericValue(choise.charAt(2));
				x = Character.getNumericValue(choise.charAt(0));

				if (x >= 0 && x < 4 && y < 4 && x >= 0) {
					try {
						gameState = gameInstance.makeMove(x, y);
					} catch (CellAlreadyTakeException e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			} catch (StringIndexOutOfBoundsException e) {
				checkUserCommand(choise);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Index out of bound");
			}

			// Checks game state
			if (gameState != GameState.PLAYING) {
				System.out.println(printFinishGameState(gameState));
				finishGame = true; // finishes the game
			}
		}
	}

	private String getChoise() {
		Scanner scan = new Scanner(System.in);
		System.out.println(players[0] + "\'s turn - insert command :");

		return scan.next();
	}

	private void printCurrentStatus() throws IOException {
		gameInstance.visualise();
	}
}