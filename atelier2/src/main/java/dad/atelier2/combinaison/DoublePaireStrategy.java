package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class DoublePaireStrategy extends AbstractStrategy implements VerificationStrategy {

	private static final int NOMBRE_CARTE_UNIQUE = 1;
	private static final int NOMBRE_PAIRE = 2;

	@Override
	public boolean isOK(Main main) {
		// Il y a une carte seule et deux paires.
		return (hasRegroupementValeur(NOMBRE_CARTE_UNIQUE, TAILLE_CARTE_UNIQUE, main) && hasRegroupementValeur(NOMBRE_PAIRE, TAILLE_PAIRE, main));
	}

}
