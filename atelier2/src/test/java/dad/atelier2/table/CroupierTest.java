package dad.atelier2.table;

import static org.junit.Assert.*;

import org.junit.Test;

import dad.atelier2.joueur.Joueur;

public class CroupierTest {

	@Test
	public void testAccueillirJoueur() {
		Croupier c = new Croupier();
		assertEquals("Il n'y a pas de joueur pour le moment.", 0, c.getNombreJoueurs());
		c.accueillir(new Joueur("toto"));
		assertEquals("Il n'y a pas de joueur pour le moment.", 1, c.getNombreJoueurs());
		c.accueillir(new Joueur("tata"));
		assertEquals("Il n'y a pas de joueur pour le moment.", 2, c.getNombreJoueurs());
	}

	@Test
	public void testDistribuer() {
		Croupier c = new Croupier();
		Joueur[] joueurs = new Joueur[] { new Joueur("toto"), new Joueur("tata"), new Joueur("titi") };
		for (Joueur j : joueurs) {
			c.accueillir(j);
		}

		for (Joueur j : joueurs) {
			assertTrue("Chaque joueur a une main vide", j.montrerMain().isVide());
		}

		c.distribuer();

		for (Joueur j : joueurs) {
			assertTrue("Chaque joueur a une main pleine", j.montrerMain().isPleine());
		}
	}

}
