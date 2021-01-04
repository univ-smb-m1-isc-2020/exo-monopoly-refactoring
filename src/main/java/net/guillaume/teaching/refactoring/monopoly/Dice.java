package net.guillaume.teaching.refactoring.monopoly;

public class Dice {

    private int value;

    public Dice() {
        roll();
    }

    public int read() {
        return value;
    }

    public void roll() {
        value = (int) (Math.random() * 6) + 1;
    }

}