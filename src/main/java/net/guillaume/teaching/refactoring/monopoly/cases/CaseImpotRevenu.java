package net.guillaume.teaching.refactoring.monopoly.cases;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public class CaseImpotRevenu extends CaseSpeciale {

	public CaseImpotRevenu() {
		super("Imp�t sur le revenu");
	}

	@Override
	public void passeDessus(Joueur joueur) {
		// Rien
	}

	@Override
	public void termineDessus(Joueur joueur) {
		// D�bit du joueur pour l'imp�t sur le revenu
		int argent = joueur.getArgent();
		joueur.debit((int)(argent * 0.1));
	}

}
