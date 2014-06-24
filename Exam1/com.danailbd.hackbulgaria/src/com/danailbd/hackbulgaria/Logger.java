package com.danailbd.hackbulgaria;


public class Logger {
	
	private int LEVEL;
    private final int DefLEVEL = 3;


	public Logger() {
		LEVEL = DefLEVEL;
	}
	
	public Logger(int lEVEL) {
		LEVEL = lEVEL;
	}

	public void setLevel(int lEVEL) {
		LEVEL = lEVEL;
	}
	
	
	public void	log(int level, String message) {
		
		if(level > 0){
			
			if(level <= LEVEL)
				System.out.print(level + " => " + message);
		}
		else{
			System.out.println("Bad input");
		}
	}

	public void	log(String message) {
		
		log(DefLEVEL, message);
	}
	
}
