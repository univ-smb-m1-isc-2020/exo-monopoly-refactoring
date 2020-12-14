package net.guillaume.teaching.refactoring.monopoly.cases;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public class CaseDepart extends CaseSpeciale {

	public CaseDepart() {
		super("Départ");
	}

	@Override
	public void passeDessus(Joueur joueur) {
		// Ajoute 200 d'argent au joueur
		joueur.credit(200);
		joueur.incrementerTour();
	}

	@Override
	public void termineDessus(Joueur joueur) {
		// Rien
	}
	
	
}
