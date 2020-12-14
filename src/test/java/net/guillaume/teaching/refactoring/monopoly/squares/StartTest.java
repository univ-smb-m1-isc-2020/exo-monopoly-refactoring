package net.guillaume.teaching.refactoring.monopoly.squares;

import net.guillaume.teaching.refactoring.monopoly.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartTest {

    private Joueur player;
    private Start underTest;

    @BeforeEach
    public void setUp() {
        player = new Joueur("Marina", "Elle", null);
        underTest = new Start();
    }


    @Test
    public void should_gain_money_when_passing_by_square() {

        // Given
        double credit = player.getCredit();

        // When
        underTest.passBy(player);

        // Then
        assertThat(player.getCredit()).isEqualTo(credit + 200);

    }

    @Test
    public void should_increment_loops_when_passing_by_square() {

        int loops = player.getLoops();

        underTest.passBy(player);

        assertThat(player.getLoops()).isEqualTo(loops + 1);

    }

    @Test
    public void should_do_nothing_when_landed_on() {

        int loops = player.getLoops();
        double credit = player.getCredit();

        underTest.landOn(player);

        assertThat(player.getLoops()).isEqualTo(loops);
        assertThat(player.getCredit()).isEqualTo(credit);

    }


}