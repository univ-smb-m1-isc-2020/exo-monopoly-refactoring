package net.guillaume.teaching.refactoring.monopoly.cases;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.guillaume.teaching.refactoring.monopoly.Joueur;
import net.guillaume.teaching.refactoring.monopoly.Plateau;

class TestCaseDepart {
	private Joueur joueur;
	private Plateau plateau;

	@BeforeEach
	void setUp() throws Exception {
		plateau = new Plateau();
		joueur = new Joueur("Testeur", "Il", plateau.depart);
	}

	@Test
	void test_case_depart_incremente_nombre_tours() {
		int numTour = joueur.getTour();
		plateau.depart.passeDessus(joueur);
		
		assertThat(joueur.getTour()).isEqualTo(numTour + 1);
	}
	
	@Test
	void test_case_depart_ajoute_argent() {
		int argent = joueur.getArgent();
		plateau.depart.passeDessus(joueur);
		
		assertThat(joueur.getArgent()).isEqualTo(argent + 200);
	}

}
