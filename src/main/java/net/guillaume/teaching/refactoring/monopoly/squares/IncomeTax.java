package net.guillaume.teaching.refactoring.monopoly.squares;

import net.guillaume.teaching.refactoring.monopoly.Player;

public class IncomeTax extends Square {

    public IncomeTax() {
        super("IncomeTax");
    }

    @Override
    public void landOn(Player player) {

        double credit = player.getCredit();
        double remaining = (int) Math.floor(credit * 0.9);
        player.debit(credit - remaining);

    }
}
