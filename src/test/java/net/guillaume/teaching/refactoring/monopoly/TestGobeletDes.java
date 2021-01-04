package net.guillaume.teaching.refactoring.monopoly;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.guillaume.teaching.refactoring.monopoly.des.De;
import net.guillaume.teaching.refactoring.monopoly.des.DePipe;
import net.guillaume.teaching.refactoring.monopoly.des.GobeletDes;

public class TestGobeletDes {
	private GobeletDes gobelet;

	@Test
	void test_lancer_des_entre_2_et_12() {
		gobelet = new GobeletDes(new De(), new De());
		
		for (int i = 0; i < 100; i++) {
			gobelet.lancer();
			assertThat(gobelet.total()).isBetween(2, 12);
		}
	}
	
	@Test
	void test_lancer_des_est_double() {
		gobelet = new GobeletDes(new DePipe(4), new DePipe(4));
		
		gobelet.lancer();
		assertThat(gobelet.estUnDouble()).isEqualTo(true);
	}
	
	@Test
	void test_lancer_des_n_est_pas_double() {
		gobelet = new GobeletDes(new DePipe(4), new DePipe(5));
		
		gobelet.lancer();
		assertThat(gobelet.estUnDouble()).isEqualTo(false);
	}
}
