package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class CarteStrategy extends AbstractStrategy implements VerificationStrategy {

	private static final int NOMBRE_CARTE_UNIQUE = 5;

	private static final VerificationStrategy COULEUR_STRATEGIE = new CouleurStrategy();
	private static final VerificationStrategy SUITE_STRATEGIE = new SuiteStrategy();

	@Override
	public boolean isOK(Main main) {
		// Il y a cinq cartes différentes.
		return hasRegroupementValeur(NOMBRE_CARTE_UNIQUE, TAILLE_CARTE_UNIQUE, main) && !COULEUR_STRATEGIE.isOK(main) && !SUITE_STRATEGIE.isOK(main);
	}

}
