package game;

public class Square {
	private boolean isRevealed;
	private boolean isBomb;
	private Integer bombsAround;
	private char state;

	public Square() {
		this.isBomb = false;
		this.state = '*';
		this.isRevealed = false;
		this.bombsAround = 0;
	}

	public char getState() {
		return state;
	}

	public void setBomb() {
		this.isBomb = true;
		this.bombsAround = -1;
		this.state = 'B';
	}

	public void increaseBombsAround() {
		if (!isBomb) {
			bombsAround++;
		}
	}

	public void reveal() {
		this.isRevealed = true;
		if(bombsAround == 0) {
			this.state = ' ';
		} else {
			String numb = bombsAround.toString();
			this.state = numb.charAt(0);			
		}
	}

	public boolean getBomb() {
		return isBomb;
	}
	
	public boolean getIsRevealed() {
		return isRevealed;
	}
}
