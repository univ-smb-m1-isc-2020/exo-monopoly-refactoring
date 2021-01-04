package net.guillaume.teaching.refactoring.monopoly;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceCupTest {


    @RepeatedTest(1000)
    public void should_always_return_values_between_2_and_12() {

        DiceCup underTest = new DiceCup(new Dice(), new Dice());

        underTest.roll();

        assertThat(underTest.total()).isBetween(2, 12);

    }

    @Test
    public void should_know_when_rolling_a_double() {

        DiceCup underTest = new DiceCup(new LoadedDice(2), new LoadedDice(2));

        underTest.roll();

        assertThat(underTest.isDouble()).isTrue();

    }

    @Test
    public void should_know_when_not_rolling_a_double() {

        DiceCup underTest = new DiceCup(new LoadedDice(1), new LoadedDice(2));

        underTest.roll();

        assertThat(underTest.isDouble()).isFalse();

    }


}