package com.danailbd;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		assertEquals("OXO\nX O\n  X", game.visualise());
	}
	
	@Test
	public void testHasWon() throws IOException{
		String case1 = "XXX\nOO \nO  ";
		String case3 = " XX\nOX \nOX ";
		String case4= "XOO\nXXX\n OO";
		String case2 = "X X\nOX O\n  X";
		String case5 = "X X\nOX O\nX  ";

		
		game = new Game(case1);
		assertEquals(true, game.hasWon());

		game = new Game(case3);
		assertEquals(true, game.hasWon());

		game = new Game(case4);	
		assertEquals(true, game.hasWon());
	
		
		game = new Game(case2);
		assertEquals(true, game.hasWon());
	
		game = new Game(case5);
		assertEquals(true, game.hasWon());

	}
	
	@Test(expected=CellAlreadyTakeException.class)
	public void testMakeMove() throws IndexOutOfBoundsException, CellAlreadyTakeException{
		game.makeMove(0, 0);

		game.makeMove(0, 0);
		assertEquals("O  \n   \n   ", game.visualise());
	
		game.makeMove(1, 0);
		assertEquals("O  \nX  \n   ", game.visualise());
	
	}

	@Test
	public void testVisualise() {
		assertEquals("   \n   \n   ", game.visualise());
	}

	@Test
	public void testRedo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUndo() {
		fail("Not yet implemented");
	}

}
