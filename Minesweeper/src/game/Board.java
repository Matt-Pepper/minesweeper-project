package game;

import java.util.Random;

public class Board {
	private Square[][] grid;
	private boolean firstMove = true;
	int gridSize;

	// creates an array of squares
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

	public String getMove() {
		new Input();
		int[] turn = Input.in.getTurn(this.grid.length);
		Square thisTurn = grid[turn[0]][turn[1]];

		if (firstMove) {
			fillBombs(turn);
			fillNumbers();
			firstMove = false;
		}

		revealSquare(turn[0], turn[1]);

		if (thisTurn.getBomb() == true) {
			thisTurn.reveal();
			return "lose";
		}

		if (checkEndGame()) {
			return "win";
		}
		return "";

	}

	public void revealSquare(int row, int col) {
		Square square = this.grid[row][col];
		if (square.getIsRevealed()) {
			return;
		}
		if (square.getBombsAround() > 0) {
			square.reveal();
		} else if (square.getBombsAround() == 0) {
			int prevRow = row - 1;
			int nextRow = row + 1;
			int prevCol = col - 1;
			int nextCol = col + 1;

			square.reveal();
			// checks row above selected square
			if (prevRow >= 0) {
				revealSquare(prevRow, col);
				if (prevCol >= 0)
					revealSquare(prevRow, prevCol);
				if (nextCol < grid.length)
					revealSquare(prevRow, nextCol);
			}

			// check selected row
			if (prevCol >= 0)
				revealSquare(row, prevCol);
			if (nextCol < grid.length)
				revealSquare(row, nextCol);

			// checks row below selected square
			if (nextRow < grid.length) {
				revealSquare(nextRow, col);
				if (prevCol >= 0)
					revealSquare(nextRow, prevCol);
				if (nextCol < grid.length)
					revealSquare(nextRow, nextCol);
			}

		}
	}

	// checks if all squares except bombs have been revealed
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
			return true;
		}
		return false;
	}

	// randomly assigns the grid with bombs, except the location of the first turn
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

	
	// this fills the squares up with how many bombs are around it
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

	// this method checks around each square for a bomb and increases bombsAround for every bomb around it
	public void increaseNumbers(int row, int col) {
		int prevRow = row - 1;
		int nextRow = row + 1;
		int prevCol = col - 1;
		int nextCol = col + 1;

		// checks previous row
		if (prevRow >= 0) {
			if (prevCol >= 0)
				grid[prevRow][prevCol].increaseBombsAround();
			grid[prevRow][col].increaseBombsAround();
			if (nextCol < grid.length)
				grid[prevRow][nextCol].increaseBombsAround();
		}

		// checks current row
		if (prevCol >= 0)
			grid[row][prevCol].increaseBombsAround();
		if (nextCol < grid.length)
			grid[row][nextCol].increaseBombsAround();

		// checks next row
		if (nextRow < grid.length) {
			if (prevCol >= 0)
				grid[nextRow][prevCol].increaseBombsAround();
			grid[nextRow][col].increaseBombsAround();
			if (nextCol < grid.length)
				grid[nextRow][nextCol].increaseBombsAround();
		}
	}

}
