package com.danailbd;

import java.io.Console;

public class GameUserInput {
	private String[] players = new String[2];
	private Game gameInstance = new Game();

	public void nameInitialisation(){
		Console consoleIn = System.console();

		players[0] = consoleIn.readLine("Enter name for user 1");
		players[1] = consoleIn.readLine("Enter name for user 2");
	}

	public void runGame() {
		nameInitialisation();

		Console consoleIn = System.console();
		while (true) {
			char choise = consoleIn.readLine().charAt(0);
			switch(choise){
			case 'q': System.out.println("Quiting...");
			return;
			}

		}
	}
}