package net.guillaume.teaching.refactoring.monopoly;

import net.guillaume.teaching.refactoring.monopoly.squares.Property;
import net.guillaume.teaching.refactoring.monopoly.squares.Square;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable {

    private final String nom;
    private final String sexe;
    private int argent;
    private Square position;
    private int nombreDeDouble;  // indique le nombre de double a la suite
    private int tour;  // indique le nombr de tour de plateau
    private boolean enPrison; // indique si le joueur est en prison
    private int tourPrison;  // indique le nombre de tour du joueur en prison
    private boolean rejouer; // indique si le joueur va rejouer suite a une double
    private boolean liberable;
    private boolean allerPrisonCeTour;
    private int v;    // indique le nombre de propriété possede de telle ou telle couleur
    private int b;
    private int p;
    private int o;
    private int r;
    private int j;
    private int w;
    private int g;
    private int gare;
    private ArrayList<Property> casespossedes = new ArrayList<>();    // contient la liste des propriété possedes

    public Player(String nom, String sexe, Square position) {
        this.nom = nom;
        this.sexe = sexe;
        argent = 400;
        nombreDeDouble = 0;
        tour = 0;
        enPrison = false;
        tourPrison = 0;
        rejouer = false;
        liberable = false;
        allerPrisonCeTour = false;
        this.position = position;
        v = 0;
        b = 0;
        p = 0;
        o = 0;
        r = 0;
        j = 0;
        w = 0;
        g = 0;
        gare = 0;
        casespossedes = new ArrayList<Property>();
    }

    public boolean getLiberable() {
        return liberable;
    }

    public Square getPosition() {
        return position;
    }

    public int getArgent() {
        return argent;
    }

    public String getNomJ() {
        return nom;
    }

    public String getSexeJ() {
        return sexe;
    }

    public boolean estEnPrison() {
        return enPrison;
    }

    public boolean rejoue() {
        return rejouer;
    }

    public boolean finDePartie() { // condition de fin de partie
        return tour == 100 || argent < 0;
    }

    public void takeTurn(DiceCup cup, Combinaison combinaison, Plateau plateau, List<Property> caseLibreAAchat, List<Player> players, Game game) {
        if (!game.stop) { //verifier avant le joueur suivant si la partie est arrete
            int[] valeurLancer = this.lancer(cup);
            int total = combinaison.faitLaSomme(valeurLancer);
            boolean verifdouble = combinaison.estUnDouble(valeurLancer);
            this.monLance(total);  // plus logique de l'afficher avant son eventuel deplacement, achat ou paiment de loyer, prison j'ai donc decomposé mon ousuisje initial
            // SI DOUBLE
            if (verifdouble) {
                this.aFaitUnDouble(plateau.prison);  // incremente double met rejouer a true, le met en prison , condition liberable
                if (!this.estEnPrison()) {        // si pas ne prison ->  jouer  son resultat
                    jouerLeTotalDe(this, total, plateau, caseLibreAAchat, players, game);
                    this.ouSuisJe();
                }
                if (this.rejoue())    // Si  il a un double il va rejouer  condition nece car appel recursif
                {
                    System.out.println(this.getNomJ() + " rejoue.");
                    this.uneFoisCaSuffis();    // on remet a false son droit de rejouer  car appel recursif
                    takeTurn(cup, combinaison, plateau, caseLibreAAchat, players, game);  // il joue un autre tour
                }
                if (this.getLiberable()) {   // libere le joueur en prison qui a fait un double
                    this.liberationDouble();
                    jouerLeTotalDe(this, total, plateau, caseLibreAAchat, players, game);
                    this.ouSuisJe();
                }
            }
            // SI PAS DOUBLE
            else {
                this.aPasFaitUnDouble();   // donc on remet compteur double à 0
                if (!this.estEnPrison()) {
                    jouerLeTotalDe(this, total, plateau, caseLibreAAchat, players, game);   // il joue son resultat
                }
                this.ouSuisJe();
            }
        }
    }

    private void jouerLeTotalDe(Player unjoueur, int total, Plateau plateau, List<Property> caseLibreAAchat, List<Player> players, Game game) {
        unjoueur.joue(total, plateau.luxe, plateau.allerenprison, plateau.prison);   // tester si cas construtible
        if (unjoueur.getPosition() instanceof Property) {
            unjoueur.acheterCase((Property) unjoueur.getPosition(), caseLibreAAchat);
            unjoueur.payerLoyer((Property) unjoueur.getPosition(), caseLibreAAchat, players);
        }
        game.stop = unjoueur.finDePartie();
        // avancer sur le plateau et faire action

    }

    public int[] lancer(DiceCup cup) {
        cup.roll();
        return cup.read();
    }

    public void ouSuisJe() {
        if (argent > 0) {
            System.out.println("Sa position est " + position.getName() + ", son argent est : " + argent + ".");
        } else {
            System.out.println("Sa position est " + position.getName() + ". " + getSexeJ() + " n'a plus d'argent.");
        }

    }


    public void monLance(int total) {
        System.out.println(nom + " fait un total pour son lancer de des de " + total + ".");
    }

    public void aFaitUnDouble(Square prison) {
        if (!enPrison && !allerPrisonCeTour) {  // NE DOIT PAS S APPLIQUER SI CASE PRISON DIRECT A CAUSE D UN DOUBLE
            nombreDeDouble++;    // si pas en prison   augmenter double de 1
            if (nombreDeDouble == 3) {   // si 3eme double il va en prison
                enPrison = true;
                position = prison;
                System.out.println(nom + " est jete en prison.");
                ouSuisJe();
            } else {
                rejouer = true;  // on indique qu'il va rejouer
            }
        } else {
            liberable = true;  // si il etait en prison on indique qu'il va etre liberer
        }
    }

    public void liberationDouble() {
        System.out.println(nom + " est libere de prison grace a un double.");
        enPrison = false;  // si en prison libere le joueur
        tourPrison = 0;
        liberable = false;
    }


    public void aPasFaitUnDouble() {
        nombreDeDouble = 0; // remettre compteur double à 0
    }

    public void uneFoisCaSuffis() {  // remettre rejouer a false qd le joueur a rejouer
        rejouer = false;
    }

    // apres chaque tour soit il sort soit on incremente son nombre de tour
    public void liberationEnVue() {
        tourPrison++;
        System.out.println(nom + " passe 1 tour en  prison.");
        allerPrisonCeTour = false;
        if (tourPrison == 4) {
            tourPrison = 0;
            argent = argent - 50;
            enPrison = false;
            System.out.println(nom + " est libere de prison.");
        }
    }

    public void joue(int total, Square lux, Square allerenpri, Square priso) {
        for (int i = 0; i < total; i++) {    // deplace le joueur en fonction du lancer
            position = position.retourneCaseSuivante();

            position.passBy(this);
        }

        position.landOn(this);

        if (lux.equals(position)) { // si il arrive sur taxe de luxe
            argent = argent - (5 * total);
        }

        if (allerenpri.equals(position)) { // si il arrive sur aller en prison
            position = priso;
            System.out.println(nom + " est sur Aller en prison. " + getSexeJ() + " va directement en prison sans passer par le départ !!!");
            allerPrisonCeTour = true;
            enPrison = true;
        }
        if (argent < 0) {  // verifie son solde apres le deplacement
            System.out.println(nom + " a perdu. " + getSexeJ() + " n'a plus d'argent !!!!");
        }
    }

    public void acheterCase(Property c, List<Property> listecase) {
        if (c.getCoutAchat() < argent && listecase.contains(c)) {  // si le joueur a argent et si la case est libre
            argent = argent - c.getCoutAchat();
            listecase.remove(c);    // enleve la case de la liste des cases libres
            System.out.println(" * " + nom + " achete " + c.getName() + " *");
            augmenterCardinalite(c.getCouleur());
            casespossedes.add(c); // ajoute a la liste des cases possedees par le joueur
        }
    }


    public void payerLoyer(Property c, List<Property> listecase, List<Player> j) {
        if (!listecase.contains(c) && !casespossedes.contains(c)) {   //si la case a un propritaire et que ce n est pas le joueur
            if (c.getCouleur() == "gare") {   // traitement du cas particulier de la gare
                int montantloyer = 0;
                int nombregare = 0;
                for (Player aJ : j) {
                    if (aJ.casespossedes.contains(c)) {
                        nombregare = aJ.getNombrePropriete(c.getCouleur()) - 1; // recupere le nombre de gare posseder par le proprietaire de la case gare -1 pr calcul loyer
                        argent = argent - c.getLoyer() * (int) Math.pow(2, nombregare);
                        if (argent >= 0) {
                            aJ.argent += c.getLoyer() * (int) Math.pow(2, nombregare);
                            montantloyer = c.getLoyer() * (int) Math.pow(2, nombregare);
                        } else {
                            aJ.argent += c.getLoyer() * (int) Math.pow(2, nombregare) + argent;  // paye tout ce qui lui reste avant de faire faillitte
                        }
                        if (argent >= 0) {
                            System.out.println(nom + " paye un loyer de " + montantloyer + " a " + aJ.getNomJ() + " car " + aJ.getNomJ() + " possede " + (nombregare + 1) + " gares.");
                        } else {
                            faireFailliteACauseLoyer();
                        }
                    }
                }
            } else {  // traitement si pas une gare
                for (Player aJ : j) {
                    if (aJ.casespossedes.contains(c)) {  // cherche le joueur qui est proprietaire de la case
                        if (aJ.getNombrePropriete(c.getCouleur()) == c.nombreProprieteDeLaCouleur(c.getCouleur())) {  // si le propriatire a toutes les propriétés
                            argent = argent - c.getLoyer() * 2;
                            if (argent >= 0) { // si  peut payer le loyer
                                aJ.argent += c.getLoyer() * 2;
                                System.out.println(nom + " paye un loyer double de " + c.getLoyer() * 2 + " a " + aJ.getNomJ() + " car " + nom + " possede toutes les proprietes de cette couleur.");
                            } else { // si il ne peut pas payer tout le loyer
                                aJ.argent += c.getLoyer() * 2 + argent;
                                faireFailliteACauseLoyer();
                            }
                        } else { // si il n a pas toutes les proprietes
                            argent = argent - c.getLoyer();
                            if (argent >= 0) { // si il paye le loyer
                                aJ.argent += c.getLoyer();
                                System.out.println(nom + " paye un loyer de " + c.getLoyer() + " a " + aJ.getNomJ() + ".");
                            } else { // si il ne peut pas payer le loyer
                                aJ.argent += c.getLoyer() + argent;
                                faireFailliteACauseLoyer();
                            }
                        }
                    }
                }
            }

        }

    }

    private void faireFailliteACauseLoyer() {
        System.out.print(getNomJ() + " ne peut pas payer le loyer en entier. Il fait faillite.");
    }


    private void augmenterCardinalite(String couleur) {   // augmente de un le nombre de propriete d une couleur
        switch (couleur) {
            case "v":
                v++;
                break;
            case "b":
                b++;
                break;
            case "p":
                p++;
                break;
            case "o":
                o++;
                break;
            case "r":
                r++;
                break;
            case "j":
                j++;
                break;
            case "w":
                w++;
                break;
            case "g":
                g++;
                break;
            case "gare":
                gare++;
                break;
        }
    }


    private int getNombrePropriete(String couleur) {  // renvoye le nombre de propriete d un certain couleur
        if (couleur == "v") {
            return v;
        } else if (couleur == "b") {
            return b;
        } else if (couleur == "p") {
            return p;
        } else if (couleur == "o") {
            return o;
        } else if (couleur == "r") {
            return r;
        } else if (couleur == "j") {
            return j;
        } else if (couleur == "w") {
            return w;
        } else if (couleur == "g") {
            return g;
        } else if (couleur == "gare") {
            return gare;
        } else return 0;
    }


    public int compareTo(Object other) {    // sert au classement fianl des joueurs
        int nombre1 = ((Player) other).getArgent();
        int nombre2 = this.getArgent();
        if (nombre1 > nombre2) return -1;
        else if (nombre1 == nombre2) return 0;
        else return 1;
    }


    public void afficherLesProprietes() { // affiche les proprietes
        int compteur = 0; // sert pour la mise en forme avec les virgules
        System.out.print(getSexeJ() + " est proprietaire de :");
        for (Property c : casespossedes) {
            if (compteur == 0) {
                System.out.print(" " + c.getName());
            } else {
                System.out.print(", " + c.getName());
            }
            compteur++;
        }
        System.out.println(".");
    }


    public void credit(int amount) {
        argent += amount;
    }

    public void incrementsLoops() {
        tour += 1;
    }

    public int getLoops() {
        return tour;
    }

    public double getCredit() {
        return argent;
    }

    public void debit(double amount) {
        argent -= amount;
    }


}

