package net.guillaume.teaching.refactoring.monopoly.des;

public class GobeletDes {
	private final De de1, de2;
	
	public GobeletDes(De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
	}

	public void lancer() {
		de1.lancer();
		de2.lancer();
	}
	
	public int total() {
		return de1.getValeur() + de2.getValeur();
	}
	
	public boolean estUnDouble() {
		return de1.getValeur() == de2.getValeur();
	}
}
