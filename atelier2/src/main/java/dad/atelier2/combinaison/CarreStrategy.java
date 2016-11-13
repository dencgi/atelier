package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class CarreStrategy extends AbstractStrategy implements VerificationStrategy {

	private static final int NOMBRE_CARRE = 1;
	private static final int NOMBRE_CARTE_UNIQUE = 1;

	@Override
	public boolean isOK(Main main) {
		// Il y a une carte unique et un carre.
		return hasRegroupementValeur(NOMBRE_CARTE_UNIQUE, TAILLE_CARTE_UNIQUE, main) && hasRegroupementValeur(NOMBRE_CARRE, TAILLE_CARRE, main);
	}

}
