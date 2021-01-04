package net.guillaume.teaching.refactoring.monopoly;

public class LoadedDice extends Dice {

    private final int value;

    public LoadedDice(int value) {
        this.value = value;
    }

    @Override
    public int read() {
        return value;
    }
}
