package dad.atelier2.carte;

public enum Couleur {

	PIQUE("pique"), COEUR("coeur"), CARREAU("carreau"), TREFLE("trefle");
	
	private String nom;
	
	private Couleur(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}
