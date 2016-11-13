package dad.atelier2.carte;

public class FabriqueCarte {

	public static Carte getCarte() {
		return new Carte(getCouleur(), getValeur());
	}

	public static Couleur getCouleur() {
		Couleur[] couleurs = Couleur.values();
		int hasard = (int) (Math.random() * couleurs.length);
		return couleurs[hasard];
	}

	public static Valeur getValeur() {
		Valeur[] valeurs = Valeur.values();
		int hasard = (int) (Math.random() * valeurs.length);
		return valeurs[hasard];
	}
}
