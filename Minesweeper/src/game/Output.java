package game;

public class Output {
	final String F_RED = "\u001B[31m";
	final String F_GREEN = "\u001B[32m";
	final String F_WHITE = "\u001B[97m";
	final String F_DEF = "\u001B[39m";
	final String B_GREY = "\u001B[47m";
	final String B_DEF = "\u001B[49m";
	final String B_BLUE = "\u001B[46m";

	public static Output out;

	public Output() {
		out = this;
	}

	public void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void printColumnNumbers(int n) {
		System.out.print(" ");
		for (int i = 0; i < n; i++) {
			System.out.format("    %3d", i);
		}
	}

	public void printGame(Board board) {
		clearConsole();
		System.out.print(F_GREEN);
		printColumnNumbers(board.getGrid().length);
		System.out.println("");
		for (int i = 0; i < board.getGrid().length; i++) {
			System.out.println("");
			System.out.format(" %-3d", i + 1);

			for (Square square : board.getGrid()[i]) {
				System.out.print(" [");
				System.out.print(B_BLUE + F_WHITE);
				System.out.print(" ");
				System.out.print(square.getState());
				System.out.print(" ");
				System.out.print(B_DEF + F_GREEN);
				System.out.print("] ");
			}
			System.out.format("%3d", i);
			System.out.println("");
		}
		System.out.println("");
		printColumnNumbers(board.getGrid().length);
	}

}
