package net.guillaume.teaching.refactoring.monopoly.cases;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public class CaseTaxeLuxe extends CaseSpeciale {

	public CaseTaxeLuxe() {
		super("Taxe de luxe");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void passeDessus(Joueur joueur) {
		// Rien
	}

	@Override
	public void termineDessus(Joueur joueur) {
		// Taxe le joueur selon son lancer total
		joueur.debit(5 * joueur.getTotalDes());
	}
}
