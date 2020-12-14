package net.guillaume.teaching.refactoring.monopoly.squares;

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


}
