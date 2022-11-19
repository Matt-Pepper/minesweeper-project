package game;

public class Board {
	private Square[][] grid;

	public Board(int size) {
		this.grid = new Square[size][size];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new Square();
			}
		}
	}

	public Square[][] getGrid() {
		return grid;
	}

}
