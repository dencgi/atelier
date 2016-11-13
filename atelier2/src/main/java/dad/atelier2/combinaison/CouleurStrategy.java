package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class CouleurStrategy extends AbstractStrategy implements VerificationStrategy {

	private static final int NOMBRE_COULEUR = 1;

	@Override
	public boolean isOK(Main main) {
		// Il y a cinq cartes de la même couleur.
		return hasRegroupementCouleur(NOMBRE_COULEUR, TAILLE_COULEUR, main);
	}

}
