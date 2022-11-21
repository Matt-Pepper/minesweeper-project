package game;

public class Output {
	// colours for font
	private final String F_RED = "\u001B[31m";
	private final String F_GREEN = "\u001B[32m";
	private final String F_YELLOW = "\u001B[33m";
	private final String F_MAGENTA = "\u001B[35m";
	private final String F_LRED = "\u001B[91m";
	private final String F_LGREEN = "\u001B[92m";
	private final String F_LYELLOW = "\u001B[33m";
	private final String F_LBLUE = "\u001B[94m";
	private final String F_WHITE = "\u001B[97m";
	private final String F_DEF = "\u001B[39m";
	
	// colours for background
	private final String B_GREY = "\u001B[47m";
	private final String B_DEF = "\u001B[49m";
	private final String B_BLUE = "\u001B[46m";
	private final String B_RED = "\u001B[41m";

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
			System.out.format("    %3d", i + 1);
		}
	}
	
	public void youLose() {
		System.out.println("\n Boom!");
	}
	
	public void youWin() {
		System.out.println("\n You Won!");
	}

	public void printGame(Board board) {
		clearConsole();
		gameStats(board);
		System.out.print(F_GREEN);
		printColumnNumbers(board.getGrid().length);
		System.out.println("");
		
		for (int i = 0; i < board.getGrid().length; i++) {
			System.out.println("");
			System.out.format(" %-3d", i + 1);
			
			for (Square square : board.getGrid()[i]) {
				System.out.print(" [");
				if(square.getIsRevealed())
				{
					System.out.print(B_GREY);
				} else {
					System.out.print(B_BLUE);

				}
				System.out.print(getColour(square.getState()));
				System.out.print(" ");
				System.out.print(square.getState());
				System.out.print(" ");
				System.out.print(B_DEF + F_GREEN);
				System.out.print("] ");
			}
			System.out.format("%3d", i + 1);
			System.out.println("");
		}
		System.out.println("");
		printColumnNumbers(board.getGrid().length);
		System.out.print(F_DEF);

	}

	public void gameStats(Board board) {
		int size = board.getGrid().length;
		System.out.println("Minesweeper with " + (size * size) + " squares");
		System.out.println("There are " + size + " bombs");
	}
		
	public String getColour(char state) {
		switch (state) {
		case '1':
			return F_RED;
		case '2':
			return F_GREEN;
		case '3':
			return F_YELLOW;
		case '4':
			return F_MAGENTA;
		case '5':
			return F_LRED;
		case '6':
			return F_LGREEN;
		case '7':
			return F_LBLUE;
		case '8':
			return F_LYELLOW;
		case 'B':
			return F_WHITE + "" + B_RED;
		default:
			return F_WHITE;

		}
	}

}
