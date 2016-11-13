package dad.atelier2.carte;

public enum Couleur {

	TREFLE("trefle"), CARREAU("carreau"), COEUR("coeur"), PIQUE("pique");

	private String nom;

	private Couleur(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}

	public static Couleur tirerAuHasard() {
		Couleur[] couleurs = Couleur.values();
		int hasard = (int) (Math.random() * couleurs.length);
		return couleurs[hasard];
	}
}
