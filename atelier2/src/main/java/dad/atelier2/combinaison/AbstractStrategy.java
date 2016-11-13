package dad.atelier2.combinaison;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.joueur.Main;

public abstract class AbstractStrategy implements VerificationStrategy {

	protected static final int TAILLE_CARTE_UNIQUE = 1;
	protected static final int TAILLE_PAIRE = 2;
	protected static final int TAILLE_BRELAN = 3;
	protected static final int TAILLE_CARRE = 4;
	protected static final int TAILLE_COULEUR = 5;
	
	private Map<Valeur, Integer> regrouperValeur(Main main) {
		Map<Valeur, Integer> analyse = new EnumMap<>(Valeur.class);
		for (Carte carte : main) {
			Valeur valeur = carte.getValeur();
			analyse.put(valeur, (analyse.containsKey(valeur) ? analyse.get(valeur) : 0) + 1);
		}
		return analyse;
	}

	private Map<Couleur, Integer> regrouperCouleur(Main main) {
		Map<Couleur, Integer> analyse = new EnumMap<>(Couleur.class);
		for (Carte carte : main) {
			Couleur couleur = carte.getCouleur();
			analyse.put(couleur, (analyse.containsKey(couleur) ? analyse.get(couleur) : 0) + 1);
		}
		return analyse;
	}

	private int compterNombreRegroupement(Collection<Integer> tailles, int tailleAttendue) {
		int nombreRegroupements = 0;
		for (int taille : tailles) {
			if (taille == tailleAttendue) {
				++nombreRegroupements;
			}
		}
		return nombreRegroupements;
	}

	protected boolean hasRegroupementCouleur(int nombreRegroupementsAttendu, int tailleRegroupementAttendu, Main main) {
		Map<Couleur, Integer> regroupement = regrouperCouleur(main);
		Collection<Integer> taillesRegroupements = regroupement.values();
		int nombreRegrouepementsTrouves = compterNombreRegroupement(taillesRegroupements, tailleRegroupementAttendu);
		return nombreRegrouepementsTrouves == nombreRegroupementsAttendu;
	}

	protected boolean hasRegroupementValeur(int nombreRegroupementsAttendu, int tailleRegroupementAttendu, Main main) {
		Map<Valeur, Integer> regroupement = regrouperValeur(main);
		Collection<Integer> taillesRegroupements = regroupement.values();
		int nombreRegrouepementsTrouves = compterNombreRegroupement(taillesRegroupements, tailleRegroupementAttendu);
		return nombreRegrouepementsTrouves == nombreRegroupementsAttendu;
	}

}
