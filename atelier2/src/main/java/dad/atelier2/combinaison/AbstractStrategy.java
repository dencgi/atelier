package dad.atelier2.combinaison;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.joueur.Main;

public abstract class AbstractStrategy implements VerificationStrategy {

	protected Map<Valeur, Integer> analyserValeur(Main main) {
		Map<Valeur, Integer> analyse = new HashMap<>();
		for (Carte carte : main) {
			Valeur valeur = carte.getValeur();
			analyse.put(valeur, (analyse.containsKey(valeur) ? analyse.get(valeur) : 0) + 1);
		}
		return analyse;
	}

	protected Map<Couleur, Integer> analyserCouleur(Main main) {
		Map<Couleur, Integer> analyse = new HashMap<>();
		for (Carte carte : main) {
			Couleur couleur = carte.getCouleur();
			analyse.put(couleur, (analyse.containsKey(couleur) ? analyse.get(couleur) : 0) + 1);
		}
		return analyse;
	}

	protected int compter(Collection<Integer> liste, int chiffre) {
		int compteur = 0;
		for (int i : liste) {
			if (i == chiffre) {
				++compteur;
			}
		}
		return compteur;
	}

}
