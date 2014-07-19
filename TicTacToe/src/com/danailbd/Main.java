package com.danailbd;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		GameUserInput game = new GameUserInput();
		try {
			game.runGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
