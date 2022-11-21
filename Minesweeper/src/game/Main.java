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
		String result = "";

		Board gameBoard = new Board(size);
		while (!gameEnded) {
			Output.out.printGame(gameBoard);
			result = gameBoard.getMove();
			if (result == "win") {
				gameEnded = true;
			}
			if (result == "lose") {
				gameEnded = true;
			}
		}
		Output.out.printGame(gameBoard);
		switch (result) {
		case "win":
			Output.out.youWin();
			break;
		case "lose":
			Output.out.youLose();
			break;
		default:
			break;
		}
	}
}
