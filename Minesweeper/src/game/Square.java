package game;

public class Square {
	private boolean isRevealed;
	private boolean isBomb;
	private int bombsAround;
	private char state;

	public Square() {
		this.isBomb = false;
		this.state = '*';
		this.isRevealed = false;
	}

	public char getState() {
		return state;
	}

	public void makeBomb() {
		this.isBomb = true;
	}

	public void checkBombsAround() {

	}

	public void reveal() {
		this.isRevealed = true;
	}

	public void checkBomb() {
		if (isRevealed && isBomb) {

		}
	}
}
