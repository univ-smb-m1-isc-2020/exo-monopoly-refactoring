package net.guillaume.teaching.refactoring.monopoly.cases;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public class CaseSpeciale extends Case{


    public CaseSpeciale(String name) {
        super(name);
    }

	@Override
	public void passeDessus(Joueur joueur) {
		// Rien
	}

	@Override
	public void termineDessus(Joueur joueur) {
		// Rien
	}
    
    

}
