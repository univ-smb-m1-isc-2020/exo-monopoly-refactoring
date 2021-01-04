package net.guillaume.teaching.refactoring.monopoly.des;

public class DePipe extends De {
	
	public DePipe() {
		this(1);
	}
	
	public DePipe(int valeurPipee) {
		valeurFace = valeurPipee;
	}
	
	@Override
	public void lancer() {
		// Un dé pipé ne change pas la valeur de sa face.
	}
}
