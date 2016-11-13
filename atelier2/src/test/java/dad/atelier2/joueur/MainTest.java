package dad.atelier2.joueur;

import static org.junit.Assert.*;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.FabriqueCarte;
import dad.atelier2.exception.MainPleineException;

public class MainTest {

	@Test
	public void testTriMain() {
		Main main = new Main();
		while (!main.isPleine()) {
			main.add(FabriqueCarte.getCarte());
		}

		// Vérification que les cartes sont dans le désordre.
		boolean nonTrie = true;
		Carte cartePrecedente = null;
		for (Carte c : main) {
			if (cartePrecedente != null) {
				nonTrie = nonTrie && cartePrecedente.compareTo(c) < 0;
			}
			cartePrecedente = c;
		}
		assertFalse("Les cartes ne sont pas triées", nonTrie);

		// Tri.
		main.trier();

		// Vérification que les cartes sont triées.
		boolean trie = true;
		cartePrecedente = null;
		for (Carte c : main) {
			if (cartePrecedente != null) {
				trie = trie && cartePrecedente.compareTo(c) < 0;
			}
			cartePrecedente = c;
		}
		assertTrue("Les cartes sont triées", trie);
	}

	@Test
	public void testMainPleine() {
		Main main = new Main();
		int tailleMain = 0;
		try {
			while (true) {
				main.add(FabriqueCarte.getCarte());
				++tailleMain;
			}
		} catch (MainPleineException e) {
			assertTrue("La main est pleine.", main.isPleine());
		}
		assertEquals("La main contient 5 cartes.", 5, tailleMain);
	}

	@Test
	public void testMainVide() {
		Main main = new Main();
		assertTrue("La main est vide.", main.isVide());
	}

}
