package net.guillaume.teaching.refactoring.monopoly;

public class DiceCup {

    private final Dice[] dice;
    int[] valeurlancer = new int[2];

    public DiceCup(Dice dice1, Dice dice2) {
        dice = new Dice[2];
        dice[0] = dice1;
        dice[1] = dice2;
    }

    public void roll() {
        for (int i = 0; i < dice.length; i++) {
            dice[0].lancer();
            valeurlancer[i] = dice[0].getValeur();
        }
    }

    public int[] read() {
        return valeurlancer;
    }

}
