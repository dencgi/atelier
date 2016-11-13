package dad.atelier2.table;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dad.atelier2.combinaison.Combinaison;
import dad.atelier2.joueur.Joueur;

public class Croupier {

	private List<Joueur> joueurs;
	private Paquet paquet;
	private Map<Combinaison, List<Joueur>> classement;

	public Croupier() {
		joueurs = new ArrayList<>();
		paquet = new Paquet();
		classement = new LinkedHashMap<>();

		// Initialisation du classement des joueurs.
		for (Combinaison combinaison : Combinaison.valuesDescendingSort()) {
			classement.put(combinaison, new ArrayList<>());
		}
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

	private void determinerClassement() {
		for (List<Joueur> joueursClassement : classement.values()) {
			joueursClassement.clear();
		}
		for (Joueur joueur : joueurs) {
			List<Joueur> joueursClassement = classement.get(Combinaison.getCombinaison(joueur.montrerMain()));
			joueursClassement.add(joueur);
		}
	}

	public List<Joueur> getGagnants() {
		determinerClassement();
		for (List<Joueur> joueurs : classement.values()) {
			if (!joueurs.isEmpty()) {
				return joueurs;
			}
		}
		return new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Croupier [joueurs=" + joueurs + ",\n paquet=" + paquet + "]\n";
	}

}
