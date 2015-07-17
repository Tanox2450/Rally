package Patate.Rally;

import java.util.List;

public class Piste {
	private final int LIGNES = 10;
	private final int COLONNES = 7;
	private String[][] matrice = new String[LIGNES][COLONNES];

	public Piste() {
	}

	public Piste(int lignes, int colonnes) {
		super();
		if (colonnes < 5)
			colonnes = 5;
		if (lignes < 5)
			lignes = 5;
		this.matrice = new String[lignes][colonnes];
	}

	public int getLIGNES() {
		return LIGNES;
	}

	public int getCOLONNES() {
		return COLONNES;
	}

	public String[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(String[][] matrice) {
		this.matrice = matrice;
	}

	public void initialiseMatrice() {
		int countLignes = 0;
		int countColonnes = 0;

		for (countLignes = 0; countLignes < this.matrice.length; countLignes++) {
			for (countColonnes = 0; countColonnes < this.matrice[countLignes].length; countColonnes++) {
				if (countColonnes == 0) {
					this.matrice[countLignes][countColonnes] = "|";
				} else {
					this.matrice[countLignes][countColonnes] = " ";
				}
			}
			countColonnes--;
			this.matrice[countLignes][countColonnes] = "|";
		}
	}

	public void afficherPiste() {
		int countLignes = 0;
		int countColonnes = 0;
		for (countLignes = 0; countLignes < this.matrice.length; countLignes++) {

			for (countColonnes = 0; countColonnes < this.matrice[countLignes].length; countColonnes++) {
				System.out.print(this.matrice[countLignes][countColonnes]);
			}
			System.out.println("");
		}
	}

	public void rafraichireMatrice(Vehicule vehicule, List<Obstacle> obstacles) {
		Position startPos = vehicule.getStartPosition();
		int y = 0;
		int x = 0;
		int countLignes = 0;
		int countColonnes = 0;

		for (countLignes = 0; countLignes < this.matrice.length; countLignes++) {
			for (countColonnes = 1; countColonnes < this.matrice[countLignes].length - 1; countColonnes++) {
				this.matrice[countLignes][countColonnes] = " ";
			}
		}

		this.matrice[startPos.getY()][startPos.getX()] = vehicule.getSymbole();

		for (Obstacle obstacle : obstacles) {
			y = obstacle.getCurrentPosition().getY();
			x = obstacle.getCurrentPosition().getX();
			this.matrice[y][x] = obstacle.getSymbole();
		}
	}
}
