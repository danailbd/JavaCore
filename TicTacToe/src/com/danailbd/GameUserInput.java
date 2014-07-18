package com.danailbd;

import java.io.Console;
import java.io.IOException;

import com.danailbd.Game.GameState;

public class GameUserInput {
	private String[] players = new String[2];
	private Game gameInstance = new Game();

	private String saveFile = "gameSave"; // local dir
	private GameState gameState = null;

	
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.load("/home/danailbd/Danailbd/testFile");
		System.out.println(game.visualise());
	}

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
				System.out.println("Quiting...");
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

	public void nameInitialisation(){
		Console consoleIn = System.console();

		players[0] = consoleIn.readLine("Enter name for user 1");
		players[1] = consoleIn.readLine("Enter name for user 2");
	}

	public void printFinishGameState(GameState gameState) {

		switch (gameState) {
		case X_WON:
			System.out.println(players[0] + " has won this game");
		case Y_WON:
			System.out.println(players[1] + " has won this game");
		case DRAW:
			System.out.println(players[0] + " and " + players[1]
					+ " has finished draw this game");
		}
	}

	// Main method for starting the game
	public void runGame() {
		nameInitialisation();
		fieldsInitialisation();

		Console consoleIn = System.console();
		boolean finishGame = false;


		while (finishGame == false) {
			String choise = consoleIn.readLine(players[0]
					+ "\'s turn - insert command :");

			int x, y;

			try {
				y = Character.getNumericValue(choise.charAt(2));
				x = Character.getNumericValue(choise.charAt(0));

				if (x >= 0 && x < 4 && y < 4 && x >= 0) {
					try {
					//	gameState = gameInstance.makeMove(x, y);
					} catch (CellAlreadyTakeException e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
			}
			catch (StringIndexOutOfBoundsException e) {
				checkUserCommand(choise);
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Index out of bound");
			}



			// Checks game state
			if (gameState != GameState.PLAYING) {
				printFinishGameState(gameState);
				return; // finishes the game
			}
		}
	}
}