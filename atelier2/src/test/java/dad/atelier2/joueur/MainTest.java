package dad.atelier2.joueur;

import static org.junit.Assert.*;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.exception.MainPleineException;

public class MainTest {

	@Test
	public void testTriMain() throws MainPleineException {
		Main main = new Main();
		while (!main.isPleine()) {
			main.add(new Carte(Couleur.tirerAuHasard(), Valeur.tirerAuHasard()));
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
	public void testMainPleine() throws MainPleineException {
		Main main = new Main();
		try {
			while (true) {
				main.add(new Carte(Couleur.tirerAuHasard(), Valeur.tirerAuHasard()));
			}
		} catch (MainPleineException e) {
			assertTrue("La main est pleine.", main.isPleine());
		}
	}

}
