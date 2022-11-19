package game;

import java.util.Scanner;

public class Input {

	public static Input in;

	public Input() {
		in = this;
	}

	public int getGameSize(Scanner scanner) {
		boolean correctInput = false;
		int output = 0;
		Output.out.clearConsole();
		System.out.println("How many rows would you like to play?");
		System.out.println("Type a number between 5-20");

		while (!correctInput) {
			try {
				output = scanner.nextInt();
				if (output >= 5 && output <= 20)
					correctInput = true;
				else
					System.out
							.println(String.format("You input %s which isn't between 5-20. Please try again", output));
			} catch (Exception e) {
				scanner.next();
				System.out.println(String.format("You input %s which isn't between 5-20. Please try again", output));
			}
		}
		return output;

	}

}
