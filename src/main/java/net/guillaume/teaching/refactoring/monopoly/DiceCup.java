package net.guillaume.teaching.refactoring.monopoly;

public class DiceCup {

    private final De[] des;
    int[] valeurlancer = new int[2];

    public DiceCup(De de1, De de2) {
        des = new De[2];
        des[0] = de1;
        des[1] = de2;
    }

    public void roll() {
        for (int i = 0; i < des.length; i++) {
            des[0].lancer();
            valeurlancer[i] = des[0].getValeur();
        }
    }

    public int[] read() {
        return valeurlancer;
    }

}
