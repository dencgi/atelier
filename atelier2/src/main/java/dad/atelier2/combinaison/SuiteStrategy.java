package dad.atelier2.combinaison;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Valeur;
import dad.atelier2.exception.NoNextValueException;
import dad.atelier2.joueur.Main;

public class SuiteStrategy extends AbstractStrategy implements VerificationStrategy {

	@Override
	public boolean isOK(Main main) {
		main.trier();
		Valeur valeurPrecedente = null;
		for (Carte carte : main) {
			if (valeurPrecedente == null) {
				valeurPrecedente = carte.getValeur();
				continue;
			}
			try {
				if (valeurPrecedente.suivant() != carte.getValeur()) {
					return false;
				}
				valeurPrecedente = carte.getValeur();
			} catch (NoNextValueException e) { //NOSONAR
				return false;
			}
		}
		return true;
	}

}
