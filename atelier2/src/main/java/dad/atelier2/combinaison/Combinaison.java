package dad.atelier2.combinaison;

import org.apache.commons.lang3.ArrayUtils;

import dad.atelier2.joueur.Main;

public enum Combinaison {
	CARTE(new CarteStrategy()),
	PAIRE(new PaireStrategy()),
	DOUBLE_PAIRE(new DoublePaireStrategy()),
	BRELAN(new BrelanStrategy()),
	SUITE(new SuiteStrategy()),
	COULEUR(new CouleurStrategy()),
	FULL(new FullStrategy()),
	CARRE(new CarreStrategy()),
	QUINTE_FLUSH(new QuinteFlushStrategy());

	private VerificationStrategy strategie;

	private Combinaison(VerificationStrategy strategie) {
		this.strategie = strategie;
	}

	public boolean verifier(Main main) {
		return strategie.isOK(main);
	}

	public static Combinaison getCombinaison(Main main) {
		// Liste des combinaisons dans l'ordre inverse, de la plus forte à la plus faible.
		for (Combinaison comb : valuesDescendingSort()) {
			if (comb.verifier(main)) {
				return comb;
			}
		}
		return Combinaison.CARTE; // Ne devrait jamais se produire.
	}

	public static Combinaison[] valuesDescendingSort() {
		Combinaison[] combs = Combinaison.values();
		ArrayUtils.reverse(combs);
		return combs;
	}

}
