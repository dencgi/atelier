package dad.atelier2.combinaison;

import java.util.Collection;
import java.util.Map;

import dad.atelier2.carte.Couleur;
import dad.atelier2.joueur.Main;

public class CouleurStrategy extends AbstractStrategy implements VerificationStrategy {

	@Override
	public boolean isOK(Main main) {
		Map<Couleur, Integer> analyse = analyserCouleur(main);
		Collection<Integer> nombreCouleur = analyse.values();
		// Il y a cinq cartes de la même couleur.
		return (compter(nombreCouleur, 5) == 1);
	}

}
