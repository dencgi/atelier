package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public class QuinteFlushStrategy implements VerificationStrategy {

	private VerificationStrategy couleurStrat = new CouleurStrategy();
	private VerificationStrategy suiteStrat = new SuiteStrategy();

	@Override
	public boolean isOK(Main main) {
		return (couleurStrat.isOK(main) && suiteStrat.isOK(main));
	}

}
