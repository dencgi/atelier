package dad.atelier2.table;

import java.util.ArrayList;
import java.util.List;

import dad.atelier2.exception.MainPleineException;
import dad.atelier2.joueur.Joueur;

public class Croupier {

	private static final int TAILLE_MAX_MAIN = 5;

	private List<Joueur> joueurs;
	private Paquet paquet;

	public Croupier() {
		joueurs = new ArrayList<>();
		paquet = new Paquet();
	}

	public void accueillir(Joueur joueur) {
		joueurs.add(joueur);
	}

	public void distribuer() {
		try {
			for (int i = 0; i < TAILLE_MAX_MAIN; ++i) {
				for (Joueur j : joueurs) {
					j.recevoirCarte(paquet.tirerCarte());
				}
			}
		} catch (MainPleineException e) {
			System.out.println("Trop de carte, tant pis !");
		}
	}

	@Override
	public String toString() {
		return "Croupier [joueurs=" + joueurs + ",\n paquet=" + paquet + "]";
	}

}
