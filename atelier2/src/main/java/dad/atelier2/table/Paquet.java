package dad.atelier2.table;

import java.util.ArrayList;
import java.util.List;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;

public class Paquet {

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
		int i = (int) (Math.random() * cartes.size());
		return cartes.remove(i);
	}

	public void ajouterCarte(Carte carte) {
		cartes.add(carte);
	}

	@Override
	public String toString() {
		return cartes.toString();
	}
}
