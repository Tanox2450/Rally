package Patate.Rally;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	private int count = 0;
	private Piste piste = new Piste();
	private Vehicule vehicule = new Vehicule();
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();

	public void incrCount() {
		count++;
	}

	public Piste getPiste() {
		return piste;
	}

	public void setPiste(Piste piste) {
		this.piste = piste;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public void initialiserPiste() {
		this.piste.initialiseMatrice();
	}

	public void afficherPiste() {
		this.rafraichirPiste();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		this.piste.afficherPiste();
	}

	public void ajouterObstacle() {
		if (count % 3 == 0) {
			Obstacle obstacle = new Obstacle();
			int x = (int) (Math.random() * (this.piste.getCOLONNES() - 2) + 1);

			obstacle.getCurrentPosition().setX(x);
			obstacle.getCurrentPosition().setY(piste.getMatrice().length - 1);
			this.obstacles.add(obstacle);
		}
	}

	public void supprimerObstacle(int index) {
		this.obstacles.remove(index);
	}

	public void etapeSuivante() {
		int y = 0;
		List<Integer> toRemove = new ArrayList<Integer>();

		this.verifierCollisions();
		for (int index = 0; index < obstacles.size(); index++) {
			y = obstacles.get(index).getCurrentPosition().getY() - 1;
			if (y < 0)
				toRemove.add(index);
			else
				obstacles.get(index).getCurrentPosition().setY(y);
		}
		for (int index : toRemove) {
			obstacles.remove(index);
		}
	}

	private void rafraichirPiste() {
		this.piste.rafraichireMatrice(this.getVehicule(), this.getObstacles());
	}

	public void verifierCollisions() {
		this.obstacles
	}
}