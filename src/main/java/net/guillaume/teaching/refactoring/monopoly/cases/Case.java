package net.guillaume.teaching.refactoring.monopoly.cases;

import net.guillaume.teaching.refactoring.monopoly.Joueur;

public abstract class Case {

    private final String name;
    private Case suivante;

    public Case(String name) {
        this.name = name;
    }

    public void setSuivante(Case c) {
        suivante = c;
    }

    public Case retourneCaseSuivante() {
        return suivante;
    }


    public String getName() {
        return name;
    }
    
    // Action effectu�e quand un joueur passe au dessus de la case
    public abstract void passeDessus(Joueur joueur);
    
    // Action effectu�e quand un joueur s'arr�te sur la case
    public abstract void termineDessus(Joueur joueur);


}
