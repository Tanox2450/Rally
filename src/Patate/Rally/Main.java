package Patate.Rally;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.initialiserPiste();
		jeu.ajouterObstacle();

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				jeu.incrCount();
				jeu.ajouterObstacle();
				jeu.afficherPiste();
				jeu.etapeSuivante();
			}
		};

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}