package dad.atelier2.carte;

import java.util.Random;

public class FabriqueCarte {

	public static Carte getCarte() {
		return new Carte(getCouleur(), getValeur());
	}

	public static Couleur getCouleur() {
		Couleur[] couleurs = Couleur.values();
		int hasard = new Random().nextInt(couleurs.length);
		return couleurs[hasard];
	}

	public static Valeur getValeur() {
		Valeur[] valeurs = Valeur.values();
		int hasard = new Random().nextInt(valeurs.length);
		return valeurs[hasard];
	}
}
