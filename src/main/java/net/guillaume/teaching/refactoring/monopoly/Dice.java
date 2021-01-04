package net.guillaume.teaching.refactoring.monopoly;

public class Dice {

    private int valeurFace;


    public Dice() {
        valeurFace = 1;
    }

    public int getValeur() {
        return valeurFace;
    }

    public void lancer() {
        valeurFace = (int) (Math.random() * 6) + 1;
    }

}