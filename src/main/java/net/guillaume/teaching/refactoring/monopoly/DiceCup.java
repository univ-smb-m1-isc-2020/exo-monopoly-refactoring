package net.guillaume.teaching.refactoring.monopoly;

import java.util.List;

import static java.util.List.of;

public class DiceCup {

    private final List<Dice> dices;

    public DiceCup(Dice dice1, Dice dice2) {
        dices = of(dice1, dice2);
    }

    public void roll() {
        dices.forEach(Dice::roll);
    }

    public int total() {
        return dices
                .stream()
                .mapToInt(Dice::read)
                .sum();
    }

    public boolean isDouble() {
        return (dices.get(0).read() == dices.get(1).read());
    }
}
