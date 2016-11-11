package dad.atelier2;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.combinaison.Combinaison;
import dad.atelier2.exception.NoNextValueException;
import dad.atelier2.joueur.Joueur;
import dad.atelier2.joueur.Main;
import dad.atelier2.table.Croupier;
import dad.atelier2.table.Paquet;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		// List<String> nomsJoueurs = Arrays.asList(new String[] { "Jean", "Paul", "Jacques", "Pierre", "Thomas", "Judas" });
		//
		// Croupier c = new Croupier();
		// for (String nomJoueur : nomsJoueurs) {
		// Joueur j = new Joueur(nomJoueur);
		// c.accueillir(j);
		// }
		//
		// System.out.println(c);
		// c.distribuer();
		// System.out.println(c);
		//
		// Paquet p = new Paquet();
		// System.out.println(p);

		// try {
		// System.out.println(Valeur.TROIS.precedent());
		// } catch (NoNextValueException e) {
		// // Rien
		// }

		try {
			Main main = new Main();
			main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
			main.add(new Carte(Couleur.COEUR, Valeur.TROIS));
			main.add(new Carte(Couleur.COEUR, Valeur.QUATRE));
			main.add(new Carte(Couleur.COEUR, Valeur.CINQ));
			main.add(new Carte(Couleur.COEUR, Valeur.SIX));
			System.out.println(main);
			main.trier();
			System.out.println(main);
			System.out.println(Combinaison.getCombinaison(main));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
