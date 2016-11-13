package dad.atelier2;

import java.util.Arrays;
import java.util.List;

import dad.atelier2.joueur.Joueur;
import dad.atelier2.table.Croupier;

public class App {

	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		List<String> nomsJoueurs = Arrays.asList(new String[] { "Pierre", "André", "Jacques", "Jean", "Philippe", "Barthélémy", "Matthieu", "Thomas", "Paul" });

		Croupier c = new Croupier();
		for (String nomJoueur : nomsJoueurs) {
			Joueur j = new Joueur(nomJoueur);
			c.accueillir(j);
		}

		c.distribuer();

		System.out.println(c);

		System.out.println(c.getGagnants());
	}

}
