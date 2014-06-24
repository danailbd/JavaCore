package com.danailbd.hackbulgaria;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateLogger extends Logger {

	public DateLogger() {
		
		System.out.print("I am not obliged to set a log level" + 
						 ", by default your class should print" +  
						 " everything in this case\n");
	}

	@Override
	public void log(int level, String message) {
		
		if(level < 4 && level > 0){
			
			System.out.printf("|%s| ",
					new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(new Date()));
		}
		super.log(level, message);
	}
	
}
