package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class BrelanStrategy extends AbstractStrategy implements VerificationStrategy {
	
	private static final int NOMBRE_BRELAN = 1;
	private static final int NOMBRE_CARTE_UNIQUE = 2;

	@Override
	public boolean isOK(Main main) {
		// Un brelan et deux cartes uniques.
		return hasRegroupementValeur(NOMBRE_CARTE_UNIQUE, TAILLE_CARTE_UNIQUE, main) && hasRegroupementValeur(NOMBRE_BRELAN, TAILLE_BRELAN, main);
	}

}
