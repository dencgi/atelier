package dad.atelier2.table;

import java.util.ArrayList;
import java.util.List;

import dad.atelier2.joueur.Joueur;

public class Croupier {

	private List<Joueur> joueurs;
	private Paquet paquet;

	public Croupier() {
		joueurs = new ArrayList<>();
		paquet = new Paquet();
	}

	public void accueillir(Joueur joueur) {
		joueurs.add(joueur);
	}

	public int getNombreJoueurs() {
		return joueurs.size();
	}

	public void distribuer() {
		boolean mainPleine = false;
		while (!mainPleine) {
			for (Joueur j : joueurs) {
				j.recevoirCarte(paquet.tirerCarte());
				mainPleine = j.montrerMain().isPleine();
			}
		}
	}

	@Override
	public String toString() {
		return "Croupier [joueurs=" + joueurs + ",\n paquet=" + paquet + "]";
	}

}
