package dad.atelier2.combinaison;

import java.util.Collection;
import java.util.Map;

import dad.atelier2.carte.Valeur;
import dad.atelier2.joueur.Main;

public class DoublePaireStrategy extends AbstractStrategy implements VerificationStrategy {

	@Override
	public boolean isOK(Main main) {
		Map<Valeur, Integer> analyse = analyserValeur(main);
		Collection<Integer> nombreValeur = analyse.values();
		// Il y a une carte seule et deux paires.
		return (compter(nombreValeur, 1) == 1 && compter(nombreValeur, 2) == 2);
	}

}
