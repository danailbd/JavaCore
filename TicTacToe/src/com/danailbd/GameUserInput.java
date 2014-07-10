package com.danailbd;

import java.io.Console;

import com.danailbd.Game.GameState;

public class GameUserInput {
	private String[] players = new String[2];
	private Game gameInstance = new Game();

	private String saveFile = "."; // local dir
	private char turn;
	private GameState gameState = null;


	public void checkUserCommand(String choise){

		switch (choise.charAt(0)) {
		case 'n':
			runGame();
			gameState = GameState.EXIT;
		case 'l':
			gameInstance.load(saveFile);
		case 's':
			gameInstance.save(saveFile);
		case 'q': System.out.println("Quiting...");
		case 'r':
			gameInstance.redo();
		case 'u':
			gameInstance.undo();
		default:
			System.out.println("Invalid opearation given");
		}
	}

	public void fieldsInitialisation() {
		Game gameInstance = new Game();
		turn = 'O';
		gameState = GameState.PLAYING;
	}

	public void nameInitialisation(){
		Console consoleIn = System.console();

		players[0] = consoleIn.readLine("Enter name for user 1");
		players[1] = consoleIn.readLine("Enter name for user 2");
	}

	public void nextTurn(){
		if(turn == 'O'){
			turn = 'X';
		} else {
			turn = 'O';
		}
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

				if (x < 10 && y < 10) {
					gameState = gameInstance.makeMove(x, y);
					nextTurn();
				}
			}
			catch (StringIndexOutOfBoundsException e) {
				checkUserCommand(choise);
			}


			// Checks game state
			if (gameState != GameState.PLAYING) {
				printFinishGameState(gameState);
				return; // finishes the game
			}
		}
	}
}