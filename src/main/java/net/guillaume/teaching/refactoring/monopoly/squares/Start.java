package net.guillaume.teaching.refactoring.monopoly.squares;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public class Start extends Square {

    public Start() {
        super("Start");
    }

    public void passBy(Joueur joueur) {
        joueur.credit(200);
        joueur.incrementsLoops();
    }

}
