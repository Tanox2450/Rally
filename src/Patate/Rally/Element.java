package Patate.Rally;

public abstract class Element {
	private String symbole = new String();
	private Position currentPosition = new Position();

	Element() {
		super();
		this.symbole = "0";
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
}
