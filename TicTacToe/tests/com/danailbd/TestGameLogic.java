package com.danailbd;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.danailbd.Game.GameState;

public class TestGameLogic {

	private Game game;
	private String testFile = "/home/danailbd/Danailbd/testFile";
	
	private PrintWriter write;
	@Before
	public void setUp() throws Exception {
		game = new Game();
		
		write = new PrintWriter(new File(testFile));
		write.print("OXO\nX O\n  X");
		write.close();
	}

	@After
	public void tearDown() throws Exception {

		new File(testFile).delete();
	}
	
	// ??????????????????????????????????????
	@Test 
	public void testLoad() throws IOException, IndexOutOfBoundsException, CellAlreadyTakeException {
		game.load(testFile);	
		assertEquals("OXO\nX O\n  X\n", game.visualise());
		
		game.makeMove(1, 1);
		assertEquals("OXO\nXOO\n  X\n", game.visualise());
	}

	@Test
	public void testSave() throws IOException {
		game.load(testFile);
		game.save(testFile);

		game.load(testFile);
		assertEquals("OXO\nX O\n  X\n", game.visualise());
	}
	
	@Test
	public void testHasWon() throws IOException{
		String case1 = "XXX\nOO \nO  ";
		String case3 = " XX\nOX \nOX ";
		String case4= "XOO\nXXX\n OO";
		String case2 = "X X\nOX \n  X";
		String case5 = "X X\nOX \nX  ";
		String case6 = "X  \nO   \n   ";

		
		game.loadState(case1);
		assertEquals(true, game.hasWon());

		game.loadState(case3);
		assertEquals(true, game.hasWon());

		game.loadState(case4);	
		assertEquals(true, game.hasWon());
	
		
		game.loadState(case2);
		assertEquals(true, game.hasWon());
	
		game.loadState(case5);
		assertEquals(true, game.hasWon());
		
		game.loadState(case6);
		assertEquals(false, game.hasWon());
	}
	
	@Test(expected=CellAlreadyTakeException.class)
	public void testMakeMove() throws IndexOutOfBoundsException, CellAlreadyTakeException{
		assertEquals(GameState.PLAYING, game.makeMove(0, 0));

		game.makeMove(0, 0);
		assertEquals("O  \n   \n   ", game.visualise());
	
		assertEquals(GameState.PLAYING, game.makeMove(1, 0));
		assertEquals("O  \nX  \n   ", game.visualise());
		
		assertEquals(GameState.PLAYING, game.makeMove(1, 1));
		assertEquals("O  \nXO \n   ", game.visualise());
		
		assertEquals(GameState.PLAYING, game.makeMove(1, 2));
		assertEquals("O  \nXOX\n   ", game.visualise());
		
		assertEquals(GameState.O_WON, game.makeMove(2, 2));
		assertEquals("O  \nXOX\n  O", game.visualise());
		
		String  case1 = "O  \nXOX\nOOX",
				case2 = "X O\nOX \nOO ",
				case3 = "  X\nOXO\n OO",
				case4 = " XX\nOXO\n OO",
				case5 = " XX\nXOO\nOX ",
				case6 = "OX \n OX\n   ";
		
		game.loadState(case1);
		assertEquals(GameState.X_WON, game.makeMove(0, 2));		
		
		game.loadState(case2);
		assertEquals(GameState.X_WON, game.makeMove(2, 2));		
		
		game.loadState(case3);
		assertEquals(GameState.X_WON, game.makeMove(2, 0));		
	
		game.loadState(case4);
		assertEquals(GameState.O_WON, game.makeMove(2, 0));
		
		game.loadState(case5);
		assertEquals(GameState.DRAW, game.makeMove(2, 2));	
		
		game.loadState(case6);
		assertEquals(GameState.O_WON, game.makeMove(2, 2));	
	}

	@Test
	public void testVisualise() {
		assertEquals("   \n   \n   ", game.visualise());
	}

	@Test(expected=EmptyStackException.class)
	public void testUndo() throws IndexOutOfBoundsException, CellAlreadyTakeException {
		String case1 = "   \n   \n   ";
		
		game.undo();
		
		game.loadState(case1);
		game.makeMove(2, 2);
		game.makeMove(1, 2);
		game.makeMove(1, 0);
		
		game.undo();
		assertEquals("   \n  X\n  O", game.visualise());
		
		game.undo();
		assertEquals("   \n   \n  O", game.visualise());
		
		game.undo();
		assertEquals("   \n   \n   ", game.visualise());
	}
	
	@Test(expected=EmptyStackException.class)
	public void testRedo() throws IndexOutOfBoundsException, CellAlreadyTakeException {
		String case1 = "   \n   \n   ";
		//game.redo();
				
		game.loadState(case1);
		game.makeMove(2, 2);
		game.makeMove(1, 2);
		game.makeMove(1, 0);
		
		game.undo();
		game.redo();
		assertEquals("   \n  X\n  O", game.visualise());
//		
//		game.undo();
//		game.undo();
//		game.redo();
//		game.redo();
//		assertEquals("   \nO X\n  O", game.visualise());
		
		game.redo();
	}
}
