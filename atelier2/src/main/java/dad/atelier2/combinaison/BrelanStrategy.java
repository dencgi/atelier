package dad.atelier2.combinaison;

import java.util.Collection;
import java.util.Map;

import dad.atelier2.carte.Valeur;
import dad.atelier2.joueur.Main;

public class BrelanStrategy extends AbstractStrategy implements VerificationStrategy {

	@Override
	public boolean isOK(Main main) {
		Map<Valeur, Integer> analyse = analyserValeur(main);
		Collection<Integer> nombreValeur = analyse.values();
		// Il y a deux cartes seules et un brelan.
		return (compter(nombreValeur, 1) == 2 && compter(nombreValeur, 3) == 1);
	}

}
