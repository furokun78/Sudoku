package model;

/**
 * Classe permettant de definir des coordonees
 * i et j (respectivement ligne et colonne) d'une case
 *
 */
public class Coordonees {
	
	private int i, j;

	public Coordonees(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
}
