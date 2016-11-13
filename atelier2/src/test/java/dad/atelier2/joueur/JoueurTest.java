package dad.atelier2.joueur;

import static org.junit.Assert.*;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.FabriqueCarte;

public class JoueurTest {

	@Test
	public void testNom() {
		String nom = "super nom";
		Joueur j = new Joueur(nom);

		assertEquals("Le nom est identique", nom, j.getNom());
	}

	@Test
	public void testRecevoirCarte() {
		Joueur j = new Joueur("toto");
		Carte carteGeneree = FabriqueCarte.getCarte();
		j.recevoirCarte(carteGeneree);

		int boucle = 0;
		for (Carte c : j.montrerMain()) {
			boucle++;
			assertTrue("La carte est la même.", c.equals(carteGeneree));
		}

		assertEquals("Il n'y a qu'une seule carte.", 1, boucle);
	}

}
