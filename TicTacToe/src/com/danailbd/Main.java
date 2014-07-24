package com.danailbd;

import java.awt.Button;
import java.io.IOException;
import java.util.Stack;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Hello, world!");
		Button button =  new Button();
		button.setLabel("TEST");
		button.setSize(SWT.DEFAULT, SWT.DEFAULT);
		button.setLocation(5, 5);
		
		shell.open();
		// run the event loop as long as the window is open
		while (!shell.isDisposed()) {
		    // read the next OS event queue and transfer it to a SWT event 
		  if (!display.readAndDispatch())
		   {
		  // if there are currently no other OS event to process
		  // sleep until the next OS event is available 
		    display.sleep();
		   }

		}

		// disposes all associated windows and their components
		display.dispose(); 
		
//		GameUserInput game = new GameUserInput();
//		try {
//			game.runGame();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
