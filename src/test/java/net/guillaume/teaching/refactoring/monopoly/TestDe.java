package net.guillaume.teaching.refactoring.monopoly;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.guillaume.teaching.refactoring.monopoly.des.De;

public class TestDe {
	private De de;
	
	@BeforeEach
	void setUp() {
		de = new De();
	}
	
	@Test
	void test_lancer_de_entre_1_et_6() {
		for (int i = 0; i < 100; i++) {
			de.lancer();
			assertThat(de.getValeur()).isBetween(1, 6);
		}
	}
	
	
}
