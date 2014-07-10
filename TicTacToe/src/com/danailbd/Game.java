package com.danailbd;

<<<<<<< HEAD
import java.util.Scanner;

public class Game {
	enum GameState {
		PLAYING, DRAW, X_WON, Y_WON, EXIT
	}

	enum Player_Symbol {
		X, O, EMPTY
	}

	private Player_Symbol currentPlayer;
	private GameState currentState;
	Board[][] board;

	public boolean Draw() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (board[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isExit() {
		if (currentState == GameState.EXIT) {
			Scanner in = new Scanner(System.in);
			System.out.println("q - quit");
			String command = in.next();
			if (command.trim().equals("q")) {
				Runtime.getRuntime().exit(0);
			}
		}
		return true;
	}

	public boolean Restart() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				board[i][j] = null;
			}
		}
		currentPlayer = Player_Symbol.X;
		currentState = GameState.PLAYING;
		return true;
	}

	public boolean Wins() {
		for(int i=0; i<3; ++i){
			for(int j=0;j<3;j++){
				if(board[i][0]==board[i][1] && board[i][1]==board[i][2]){
					return true;
				}
				if (board[0][j]==board[1][j] && board[1][j]==board[2][j]){
					return true;
				}
				if(board[0][0] ==board[1][1] && board[1][1] == board[2][2] ){
					return true;
				}
				if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
					return true;
				}
			}
		}
		return false;
	}
=======
public class Game {
>>>>>>> 6bc0747d70940c0ecee370abb30b953b1fbd87ad

}
