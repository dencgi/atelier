package dad.atelier2.combinaison;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

	public static String getCombinaison(Main main) {
		// Liste des combinaisons dans l'ordre inverse, de la plus forte à la plus faible.
		List<Combinaison> combinaisons=  Arrays.asList(Combinaison.values());
		Collections.reverse(combinaisons);
		
		for (Combinaison comb : combinaisons) {
			if (comb.verifier(main)) {
				return comb.toString();
			}
		}
		return ""; // Ne devrait jamais se produire.
	}

}
