package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class FullStrategy extends AbstractStrategy implements VerificationStrategy {

	private static final int NOMBRE_PAIRE = 1;
	private static final int NOMBRE_BRELAN = 1;

	@Override
	public boolean isOK(Main main) {
		// Il y a une paire et un brelan.
		return hasRegroupementValeur(NOMBRE_PAIRE, TAILLE_PAIRE, main) && hasRegroupementValeur(NOMBRE_BRELAN, TAILLE_BRELAN, main);
	}

}
