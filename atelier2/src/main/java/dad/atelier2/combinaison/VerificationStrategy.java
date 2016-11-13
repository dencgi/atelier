package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

@FunctionalInterface
public interface VerificationStrategy {

	boolean isOK(Main main);
}
