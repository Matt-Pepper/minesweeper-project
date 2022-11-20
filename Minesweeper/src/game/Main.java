package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Input();
		new Output();

		try (Scanner scanner = new Scanner(System.in)) {

			int size = Input.in.getGameSize();
			playGame(size);

		}

	}

	public static void playGame(int size) {
		boolean gameEnded = false;

		Board gameBoard = new Board(size);
		while (!gameEnded) {
			Output.out.printGame(gameBoard);
			gameEnded = gameBoard.getMove();
		}
	}
}
