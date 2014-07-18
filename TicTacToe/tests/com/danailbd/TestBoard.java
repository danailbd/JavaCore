package com.danailbd;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestBoard {
	private Board board;
	private String testBoard = "OX \nX O\n  X";
	public ExpectedException exception = ExpectedException.none();


	@Before
	public void setUp() throws Exception {
		board = new Board(testBoard);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=CellAlreadyTakeException.class)
	public void testAddSymbol() throws IndexOutOfBoundsException, CellAlreadyTakeException {
		
		board.addSymbol('O', new Point(0, 2));
		assertEquals("OXO\nX O\n  X", board.getCurruntBoard());
		
		// --- test exception ---
		
		board.addSymbol('X', new Point(0, 2));
		assertEquals("OXO\nX O\n  X", board.getCurruntBoard());
		
		board.addSymbol('X', new Point(2, 1));
		assertEquals("OXO\nX O\n XX", board.getCurruntBoard());
	}

	@Test
	public void testGetCurruntBoard() {
		assertEquals("OX \nX O\n  X", board.getCurruntBoard());
	}

}
