package com.danailbd;

class CellAlreadyTakeException extends Exception {

	private int x, y;

	public CellAlreadyTakeException(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String getMessage() {
		return "Cell already taken";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
