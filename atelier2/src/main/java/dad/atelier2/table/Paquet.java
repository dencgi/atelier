package dad.atelier2.table;

import java.util.ArrayList;
import java.util.List;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.exception.PaquetVideException;

public class Paquet {

	private static final int TAILLE_MAX = Valeur.values().length * Couleur.values().length;
	private static final int TAILLE_VIDE = 0;

	private List<Carte> cartes;

	public Paquet() {
		init();
	}

	public void init() {
		cartes = new ArrayList<>();
		for (Valeur valeur : Valeur.values()) {
			for (Couleur couleur : Couleur.values()) {
				Carte carte = new Carte(couleur, valeur);
				cartes.add(carte);
			}
		}
	}

	public Carte tirerCarte() {
		if (isVide()) {
			throw new PaquetVideException();
		}
		int i = (int) (Math.random() * cartes.size());
		return cartes.remove(i);
	}

	public boolean isPlein() {
		return cartes.size() == TAILLE_MAX;
	}

	public boolean isVide() {
		return cartes.size() == TAILLE_VIDE;
	}

	@Override
	public String toString() {
		return cartes.toString();
	}
}
