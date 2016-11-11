package dad.atelier2.combinaison;

import java.util.Collection;
import java.util.Map;

import dad.atelier2.carte.Valeur;
import dad.atelier2.joueur.Main;

public class CarteStrategy extends AbstractStrategy implements VerificationStrategy {

	VerificationStrategy couleurStrategie = new CouleurStrategy();
	VerificationStrategy suiteStrategie = new SuiteStrategy();

	@Override
	public boolean isOK(Main main) {
		Map<Valeur, Integer> analyse = analyserValeur(main);
		Collection<Integer> nombreValeur = analyse.values();
		// Il y a cinq cartes différentes.
		return (compter(nombreValeur, 1) == 5 && !couleurStrategie.isOK(main) && !suiteStrategie.isOK(main));
	}

}
