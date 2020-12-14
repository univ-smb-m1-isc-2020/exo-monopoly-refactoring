package net.guillaume.teaching.refactoring.monopoly;

import net.guillaume.teaching.refactoring.monopoly.squares.Square;
import net.guillaume.teaching.refactoring.monopoly.squares.Property;
import net.guillaume.teaching.refactoring.monopoly.squares.SpecialSquare;

import java.util.ArrayList;

public class Plateau {


    public Square depart;
    public Property bellevile;
    public Property lecourbe;
    public Property vaugirard;
    public Property courcelles;
    public Property republique;
    public Property neuilly;
    public Property villette;
    public Property paradis;
    public Property mozart;
    public Property stmichel;
    public Property pigalle;
    public Property malesherbes;
    public Property matignon;
    public Property henrimartin;
    public Property bourse;
    public Property sthonore;
    public Property fayette;
    public Property foch;
    public Property breteuil;
    public Property capucines;
    public Property champs;
    public Property paix;
    public SpecialSquare luxe;
    public SpecialSquare impot;
    public SpecialSquare prison;
    public SpecialSquare allerenprison;
    public Property garemontparnasse;
    public Property garedelyon;
    public Property garedunord;
    public Property garesaintlazard;
    private ArrayList<Property> caseSansProprietaire = new ArrayList<>();

    public Plateau(){
    creerLesCases();
    creerLesCasesSuivantes();
    genererListeCaseSansProprietaire();
    }




    private void creerLesCases(){
    depart = new SpecialSquare("Depart");
    bellevile = new Property("Boulevard de Bellevile", 20, 2,"v");
    lecourbe = new Property("Rue Lecourbe", 40, 4, "v");
    vaugirard = new Property("Rue Vaugirard", 60, 6,"b");
    courcelles = new Property("Rue De Courcelles", 60, 6,"b");
    republique = new Property("Avenue de la Republique", 80, 8,"b");
    neuilly = new Property("Avenue de Neuilly", 100, 10,"p");
    villette = new Property("Boulevard de la Villette", 100, 10,"p");
    paradis = new Property("Rue de Paradis", 120, 12,"p");
    mozart = new Property("Avenue Mozart", 140, 14,"o");
    stmichel = new Property("Boulevard St Michel", 140, 14,"o");
    pigalle = new Property("Place Pigalle", 160, 16,"o");
    malesherbes = new Property("Boulevard Malesherbes", 180, 18,"r");
    matignon = new Property("Avenue Matignon", 180, 18,"r");
    henrimartin = new Property("Avenue Henri Martin", 200, 20,"r");
    bourse = new Property("Place de la Bourse", 220, 22,"j");
    sthonore = new Property("Faubourg St Honore", 220, 20,"j");
    fayette = new Property("Rue de la Fayette", 240, 24,"j");
    foch = new Property("Avenue Foch", 260, 26,"w");
    breteuil = new Property("Avenue de Breteuil", 260, 26,"w");
    capucines = new Property("Boulevard des Capucines", 280, 28,"w");
    champs = new Property("Avenue des Champs Elysees", 300, 30,"g");
    paix = new Property("Rue de la paix",350,35,"g");
    impot = new SpecialSquare("Impot sur le Revenu");
    luxe = new SpecialSquare("Taxe de Luxe");
    prison = new SpecialSquare("Prison");
    allerenprison = new SpecialSquare("Aller en Prison");
    garedelyon = new Property("Gare De Lyon",120,25,"gare");
    garemontparnasse = new Property("Gare Mont-Parnasse",120,25,"gare");
    garedunord = new Property("Gare Du Nord",120,25,"gare");
    garesaintlazard = new Property("Gare Saint-Lazar",120,25,"gare");
    }

    private void creerLesCasesSuivantes(){
    depart.setSuivante(bellevile);
    bellevile.setSuivante(lecourbe);
    lecourbe.setSuivante(impot);
    impot.setSuivante(garemontparnasse);
    garemontparnasse.setSuivante(vaugirard);
    vaugirard.setSuivante(courcelles);
    courcelles.setSuivante(republique);
    republique.setSuivante(prison);
    prison.setSuivante(villette);
    villette.setSuivante(neuilly);
    neuilly.setSuivante(paradis);
    paradis.setSuivante(garedelyon);
    garedelyon.setSuivante(mozart);
    mozart.setSuivante(stmichel);
    stmichel.setSuivante(pigalle);
    pigalle.setSuivante(matignon);
    matignon.setSuivante(malesherbes);
    malesherbes.setSuivante(henrimartin);
    henrimartin.setSuivante(garedunord);
    garedunord.setSuivante(sthonore);
    sthonore.setSuivante(bourse);
    bourse.setSuivante(fayette);
    fayette.setSuivante(allerenprison);
    allerenprison.setSuivante(breteuil);
    breteuil.setSuivante(foch);
    foch.setSuivante(capucines);
    capucines.setSuivante(garesaintlazard);
    garesaintlazard.setSuivante(champs);
    champs.setSuivante(luxe);
    luxe.setSuivante(paix);
    paix.setSuivante(depart);

}


    private void genererListeCaseSansProprietaire(){
        caseSansProprietaire.add(bellevile);
        caseSansProprietaire.add(lecourbe);
        caseSansProprietaire.add(vaugirard);
        caseSansProprietaire.add(courcelles);
        caseSansProprietaire.add(republique);
        caseSansProprietaire.add(neuilly);
        caseSansProprietaire.add(villette);
        caseSansProprietaire.add(paradis);
        caseSansProprietaire.add(mozart);
        caseSansProprietaire.add(stmichel);
        caseSansProprietaire.add(pigalle);
        caseSansProprietaire.add(malesherbes);
        caseSansProprietaire.add(matignon);
        caseSansProprietaire.add(henrimartin);
        caseSansProprietaire.add(bourse);
        caseSansProprietaire.add(sthonore);
        caseSansProprietaire.add(fayette);
        caseSansProprietaire.add(foch);
        caseSansProprietaire.add(breteuil);
        caseSansProprietaire.add(capucines);
        caseSansProprietaire.add(champs);
        caseSansProprietaire.add(paix);
        caseSansProprietaire.add(garedelyon);
        caseSansProprietaire.add(garedunord);
        caseSansProprietaire.add(garemontparnasse);
        caseSansProprietaire.add(garesaintlazard);


    }

    public ArrayList<Property> getCaseAchetable(){
          return caseSansProprietaire;
    }
}
