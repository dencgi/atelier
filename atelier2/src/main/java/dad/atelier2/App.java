package dad.atelier2;

import java.util.Arrays;
import java.util.List;

import dad.atelier2.joueur.Joueur;
import dad.atelier2.table.Croupier;

public class App {

	private App() {
		// Classe statique.
	}

	public static void main(String[] args) {
		List<String> nomsJoueurs = Arrays.asList(new String[] { "Pierre", "André", "Jacques", "Jean", "Philippe", "Barthélémy", "Matthieu", "Thomas", "Paul" });

		Croupier c = new Croupier();
		for (String nomJoueur : nomsJoueurs) {
			Joueur j = new Joueur(nomJoueur);
			c.accueillir(j);
		}

		c.distribuer();

		System.out.println(c); // NOSONAR

		System.out.println(c.getGagnants()); // NOSONAR
	}

}
