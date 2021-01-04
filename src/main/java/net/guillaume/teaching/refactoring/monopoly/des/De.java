package net.guillaume.teaching.refactoring.monopoly.des;

public class De {

    protected int valeurFace;


    public De() {
        valeurFace = 1;
    }

    public int getValeur() {
        return valeurFace;
    }

    public void lancer() {
        valeurFace = (int) (Math.random() * 6) + 1;
    }

}