package net.guillaume.teaching.refactoring.monopoly;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceTest {

    @Test
    public void should_always_return_a_value_between_1_and_6() {

        Dice underTest = new Dice();

        assertThat(underTest.read()).isBetween(1, 6);

    }


}