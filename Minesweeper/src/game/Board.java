package game;

import java.util.Random;

public class Board {
	private Square[][] grid;
	private boolean firstMove = true;
	int gridSize;

	public Board(int size) {
		this.grid = new Square[size][size];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new Square();
			}
		}
		this.gridSize = size * size;
	}

	public Square[][] getGrid() {
		return grid;
	}

	public boolean getMove() {
		new Input();
		int[] turn = Input.in.getTurn(this.grid.length);

		if (firstMove) {
			fillBombs(turn);
			fillNumbers();
			firstMove = false;
		}

		if (grid[turn[0]][turn[1]].getBomb() == true) {
			System.out.println("Boom!");
			return true;
		}

		this.grid[turn[0]][turn[1]].reveal();

		return checkEndGame();

	}

	public boolean checkEndGame() {
		int validTurns = (gridSize) - grid.length;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				Square square = grid[i][j];
				if (square.getBomb() == false && square.getIsRevealed()) {
					count++;
				}
			}
		}
		if (count == validTurns) {
			System.out.println("You Won!!");
			return true;
		}
		return false;
	}

	public void fillBombs(int[] firstTurn) {
		int bombCount = 0;

		Random random = new Random();
		while (bombCount < grid.length) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					Square square = grid[i][j];
					if (bombCount == grid.length) {
						break;
					}
					int randomNum = random.nextInt(gridSize) + 1;
					if (randomNum <= grid.length && i != firstTurn[0] && j != firstTurn[1] && !square.getBomb()) {
						square.setBomb();
						bombCount++;
					}
				}
			}
		}
	}

	public void fillNumbers() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				Square square = grid[i][j];
				if (square.getBomb()) {
					square.increaseBombsAround();
					increaseNumbers(i, j);
				}
			}
		}
	}

	public void increaseNumbers(int row, int col) {
		int prevRow = row - 1;
		int nextRow = row + 1;
		int prevCol = col - 1;
		int nextCol = col + 1;

		if (prevRow >= 0) {
			if (prevCol >= 0)
				grid[prevRow][prevCol].increaseBombsAround();
			grid[prevRow][col].increaseBombsAround();
			if (nextCol < grid.length)
				grid[prevRow][nextCol].increaseBombsAround();
		}

		if (prevCol >= 0)
			grid[row][prevCol].increaseBombsAround();
		if (nextCol < grid.length)
			grid[row][nextCol].increaseBombsAround();

		if (nextRow < grid.length) {
			if (prevCol >= 0)
				grid[nextRow][prevCol].increaseBombsAround();
			grid[nextRow][col].increaseBombsAround();
			if (nextCol < grid.length)
				grid[nextRow][nextCol].increaseBombsAround();
		}
	}

}
