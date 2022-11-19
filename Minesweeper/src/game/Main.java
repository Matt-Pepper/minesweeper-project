package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Input();
		new Output();

		try (Scanner scanner = new Scanner(System.in)) {

			int size = Input.in.getGameSize(scanner);

			Board gameBoard = new Board(size);
			Output.out.clearConsole();

			System.out.println("Minesweeper with " + (size * size) + " squares");
			System.out.println("There are " + size + " bombs");

			Output.out.printGame(gameBoard);

		}

	}
}
