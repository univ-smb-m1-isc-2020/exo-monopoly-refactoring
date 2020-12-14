package net.guillaume.teaching.refactoring.monopoly.squares;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public abstract class Square {

    private final String name;
    private Square suivante;

    public Square(String name) {
        this.name = name;
    }

    public void setSuivante(Square c) {
        suivante = c;
    }

    public Square retourneCaseSuivante() {
        return suivante;
    }


    public String getName() {
        return name;
    }

    public void passBy(Joueur joueur) {
        // default behavior for most of the squares but Start.
    }

    public void landOn(Joueur joueur) {
        // default behavior for most of the squares but Start.
    }
}
