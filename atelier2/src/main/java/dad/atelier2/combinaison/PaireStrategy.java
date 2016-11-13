package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class PaireStrategy extends AbstractStrategy implements VerificationStrategy {

	private static final int NOMBRE_CARTE_UNIQUE = 3;
	private static final int NOMBRE_PAIRE = 1;

	@Override
	public boolean isOK(Main main) {
		// Il y a trois cartes seules et une paire.
		return (hasRegroupementValeur(NOMBRE_CARTE_UNIQUE, TAILLE_CARTE_UNIQUE, main) && hasRegroupementValeur(NOMBRE_PAIRE, TAILLE_PAIRE, main));
	}

}
