package game;

import java.util.Scanner;

public class Input {

	public static Input in;
	Scanner scanner = new Scanner(System.in);

	public Input() {
		in = this;
	}

	public int getGameSize() {
		int output = 0;
		Output.out.clearConsole();
		System.out.println("How many rows would you like to play?");
		System.out.println("Type a number between 5-20");

		output = getInt(5, 20);
		return output;

	}

	public int[] getTurn(int size) {
		int[] turn = { 0, 0 };

		System.out.print("\n \n");

		System.out.println("Select a row by typing a number between 1-" + size);
		turn[0] = getInt(1, size) - 1;

		System.out.println("Select a column by typing a number between 1-" + size);
		turn[1] = getInt(1, size) - 1;
		return turn;
	}

	public int getInt(int min, int max) {
		boolean validInput = false;
		int output = 0;
		while (!validInput) {
			try {
				output = this.scanner.nextInt();
				if (output >= min && output <= max)
					validInput = true;
				else
					System.out.println(
							String.format("Your input %s. Isn't between %s-%s. Please try again", output, min, max));
			} catch (Exception e) {
				this.scanner.next();
				System.out.println(
						String.format("Your input %s. Isn't between %s-%s. Please try again", output, min, max));
			}
		}

		return output;

	}

}
