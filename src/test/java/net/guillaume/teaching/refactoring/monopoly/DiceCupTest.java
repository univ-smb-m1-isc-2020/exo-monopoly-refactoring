package net.guillaume.teaching.refactoring.monopoly;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceCupTest {


    @Test
    public void should_always_return_values_between_1_and_6() {

        DiceCup underTest = new DiceCup(new De(), new De());
        underTest.roll();
        int[] result = underTest.read();

        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(2);
        assertThat(result[0]).isBetween(1, 6);
        assertThat(result[1]).isBetween(1, 6);

    }


}