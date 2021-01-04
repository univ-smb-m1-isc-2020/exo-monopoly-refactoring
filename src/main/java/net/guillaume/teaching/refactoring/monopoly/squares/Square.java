package net.guillaume.teaching.refactoring.monopoly.squares;

import net.guillaume.teaching.refactoring.monopoly.Player;

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

    public void passBy(Player player) {
        // default behavior for most of the squares but Start.
    }

    public void landOn(Player player) {
        // default behavior for most of the squares but Start.
    }
}
