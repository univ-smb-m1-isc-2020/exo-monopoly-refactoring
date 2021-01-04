package net.guillaume.teaching.refactoring.monopoly;

import net.guillaume.teaching.refactoring.monopoly.squares.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Player> players = new ArrayList<>();

    public boolean stop = false;
    private ArrayList<Property> caseLibreAAchat;
    private Plateau plateau;
    private final DiceCup cup;


    public Game() {
        plateau = new Plateau();
        players.add(new Player("Marina", "Elle", plateau.depart));
        players.add(new Player("Ambre", "Elle", plateau.depart));
        players.add(new Player("Loubna", "Elle", plateau.depart));
        players.add(new Player("Mathieu", "Il", plateau.depart));
        players.add(new Player("Cedric", "Il", plateau.depart));
        caseLibreAAchat = new ArrayList<>(plateau.getCaseAchetable());
        cup = new DiceCup(new Dice(), new Dice());
    }


    public void play() {
        while (!stop) {
            for (Player player : players) {
                player.takeTurn(cup, plateau, caseLibreAAchat, players, this);
                liberer(player);
            }
        }
        afficheFinDePartie();
    }


    private void liberer(Player unjoueur) {
        if (unjoueur.estEnPrison())  // verifier si il est prison
        {
            unjoueur.liberationEnVue();   //   incrementer le nombre de tour et si 3 le liberer
        }
    }


    private void afficheFinDePartie() {
        System.out.println("La partie est terminee !!!");   // L'affichage de la suite etait pas deamnde mais ca parait plus coherent
        trie();
        System.out.println("Le vainqueur est " + players.get(0).getNomJ() + " avec " + players.get(0).getArgent() + ".");
        players.get(0).afficherLesProprietes();
        for (int i = 1; players.size() > i; i++) {
            if (players.get(i).getArgent() > 0) {
                System.out.println(players.get(i).getNomJ() + " est " + (i + 1) + " place avec " + players.get(i).getArgent() + ".");
                players.get(i).afficherLesProprietes();
            } else {
                System.out.println(players.get(i).getNomJ() + " est " + (i + 1) + " place avec 0 argent.");
                players.get(i).afficherLesProprietes();
            }
        }
    }

    private void trie() {  // non demande mais il me parait logique d afficher dans ordre
        Collections.sort(players);
        Collections.sort(players, Collections.reverseOrder());
    }


}

