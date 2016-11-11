package dad.atelier2.combinaison;

import dad.atelier2.joueur.Main;

public enum Combinaison {
	QUINTE_FLUSH(new QuinteFlushStrategy()),
	CARRE(new CarreStrategy()),
	FULL(new FullStrategy()),
	COULEUR(new CouleurStrategy()),
	SUITE(new SuiteStrategy()),
	BRELAN(new BrelanStrategy()),
	DOUBLE_PAIRE(new DoublePaireStrategy()),
	PAIRE(new PaireStrategy()),
	CARTE(new CarteStrategy());

	private VerificationStrategy strategie;

	private Combinaison(VerificationStrategy strategie) {
		this.strategie = strategie;
	}

	public boolean verifier(Main main) {
		return strategie.isOK(main);
	}

	public static String getCombinaison(Main main) {
		for (Combinaison comb : Combinaison.values()) {
			if (comb.verifier(main)) {
				return comb.toString();
			}
		}
		return ""; // Ne devrait jamais se produire.
	}

}
