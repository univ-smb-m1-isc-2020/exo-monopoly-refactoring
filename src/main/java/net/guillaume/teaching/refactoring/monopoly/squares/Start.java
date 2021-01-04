package net.guillaume.teaching.refactoring.monopoly.squares;

import net.guillaume.teaching.refactoring.monopoly.Player;

public class Start extends Square {

    public Start() {
        super("Start");
    }

    public void passBy(Player player) {
        player.credit(200);
        player.incrementsLoops();
    }

}
