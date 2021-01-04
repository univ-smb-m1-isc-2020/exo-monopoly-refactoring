package net.guillaume.teaching.refactoring.monopoly;

import net.guillaume.teaching.refactoring.monopoly.squares.Property;

import java.util.ArrayList;
import java.util.Collections;

public class JeuDeMonopoly {

    private final ArrayList<Joueur> joueurs = new ArrayList<>();
    private final Combinaison combinaison;
    public boolean stop = false;
    private ArrayList<Property> caseLibreAAchat = new ArrayList<>();
    private Plateau plateau;
    private final DiceCup cup;


    public JeuDeMonopoly() {
        plateau = new Plateau();
        joueurs.add(new Joueur("Marina", "Elle", plateau.depart));
        joueurs.add(new Joueur("Ambre", "Elle", plateau.depart));
        joueurs.add(new Joueur("Loubna", "Elle", plateau.depart));
        joueurs.add(new Joueur("Mathieu", "Il", plateau.depart));
        joueurs.add(new Joueur("Cedric", "Il", plateau.depart));
        combinaison = new Combinaison();
        caseLibreAAchat = new ArrayList<>(plateau.getCaseAchetable());
        cup = new DiceCup(new Dice(), new Dice());
    }


    public void jouerUnePartie() {
        while (!stop) {
            for (Joueur joueur : joueurs) {
                joueur.jouerUnTour(cup, combinaison, plateau, caseLibreAAchat, joueurs, this);
                liberer(joueur);
            }
        }
        afficheFinDePartie();
    }


    private void liberer(Joueur unjoueur) {
        if (unjoueur.estEnPrison())  // verifier si il est prison
        {
            unjoueur.liberationEnVue();   //   incrementer le nombre de tour et si 3 le liberer
        }
    }


    private void afficheFinDePartie() {
        System.out.println("La partie est terminee !!!");   // L'affichage de la suite etait pas deamnde mais ca parait plus coherent
        trie();
        System.out.println("Le vainqueur est " + joueurs.get(0).getNomJ() + " avec " + joueurs.get(0).getArgent() + ".");
        joueurs.get(0).afficherLesProprietes();
        for (int i = 1; joueurs.size() > i; i++) {
            if (joueurs.get(i).getArgent() > 0) {
                System.out.println(joueurs.get(i).getNomJ() + " est " + (i + 1) + " place avec " + joueurs.get(i).getArgent() + ".");
                joueurs.get(i).afficherLesProprietes();
            } else {
                System.out.println(joueurs.get(i).getNomJ() + " est " + (i + 1) + " place avec 0 argent.");
                joueurs.get(i).afficherLesProprietes();
            }
        }
    }

    private void trie() {  // non demande mais il me parait logique d afficher dans ordre
        Collections.sort(joueurs);
        Collections.sort(joueurs, Collections.reverseOrder());
    }


}

