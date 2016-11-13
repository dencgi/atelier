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
	
	@Test
	public void testMainVide() {
		Joueur j = new Joueur("toto");
		assertTrue("La main du joueur est vide.", j.montrerMain().isVide());
		
		j.recevoirCarte(FabriqueCarte.getCarte());
		assertFalse("La main du joueur n'est pas vide.", j.montrerMain().isVide());
	}
	
	@Test
	public void testJeterMain() {
		Joueur j = new Joueur("toto");
		assertTrue("La main du joueur est vide.", j.montrerMain().isVide());
		
		j.recevoirCarte(FabriqueCarte.getCarte());
		assertFalse("La main du joueur n'est pas vide.", j.montrerMain().isVide());
		
		j.jeterMain();
		assertTrue("La main du joueur est à nouveau vide.", j.montrerMain().isVide());
	}
	
	@Test
	public void testMainImmuable() {
		Joueur j = new Joueur("toto");
		assertTrue("La main du joueur est vide.", j.montrerMain().isVide());
		j.montrerMain().add(FabriqueCarte.getCarte());
		assertTrue("La main du joueur est toujours vide.", j.montrerMain().isVide());
	}

}
