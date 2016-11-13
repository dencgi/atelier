package dad.atelier2.combinaison;

import static org.junit.Assert.*;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.combinaison.Combinaison;
import dad.atelier2.joueur.Main;

/*
 * Faire passer les tests JUnit ci-dessous.
 * 
 * Une carte a une couleur (pique, cœur, carreau ou trèfle) et une valeur (2, 3, ..., roi, as)
 * 
 * Ordre des cartes : 2, 3, 4, ..., 9, 10, valet, dame, roi, as.
 * 
 * Combinaisons possibles, du plus fort au moins fort :
 * - quinte flush : cinq cartes de la même couleur et dont les valeurs se suivent.
 * - carré : quatre cartes de même valeur.
 * - full : un brelan + une paire.
 * - couleur : cinq carte de la même couleur.
 * - suite : cinq cartes dont les valeurs se suivent.
 * - brelan : 3 cartes de la même valeur.
 * - double paire : deux paires.
 * - paire : deux cartes de la même valeur.
 * - carte : aucune autre combinaison.
 * 
 */
public class CombinaisonTest {

	@Test
	public void testQuinteFlush() {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection de la quinte flush !", Combinaison.QUINTE_FLUSH, Combinaison.getCombinaison(main));
	}

	@Test
	public void testCarre() {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		assertEquals("Problème lors de la détection du carré !", Combinaison.CARRE, Combinaison.getCombinaison(main));
	}

	@Test
	public void testFull() {
		Main main = new Main();
		main.add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.add(new Carte(Couleur.CARREAU, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.COEUR, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		assertEquals("Problème lors de la détection du full !", Combinaison.FULL, Combinaison.getCombinaison(main));
	}

	@Test
	public void testCouleur() {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection de la couleur !", Combinaison.COULEUR, Combinaison.getCombinaison(main));
	}

	@Test
	public void testSuite() {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.PIQUE, Valeur.HUIT));
		assertEquals("Problème lors de la détection de la suite !", Combinaison.SUITE, Combinaison.getCombinaison(main));
	}

	@Test
	public void testBrelan() {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.PIQUE, Valeur.VALET));
		main.add(new Carte(Couleur.COEUR, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection du brelan !", Combinaison.BRELAN, Combinaison.getCombinaison(main));
	}

	@Test
	public void testDoublePaire() {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.CARREAU, Valeur.ROI));
		assertEquals("Problème lors de la détection de la double paire !", Combinaison.DOUBLE_PAIRE, Combinaison.getCombinaison(main));
	}

	@Test
	public void testPaire() {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.CARREAU, Valeur.VALET));
		assertEquals("Problème lors de la détection de la paire !", Combinaison.PAIRE, Combinaison.getCombinaison(main));
	}

	@Test
	public void testCarte() {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection de la carte !", Combinaison.CARTE, Combinaison.getCombinaison(main));
	}

	@Test
	public void testOrdre() {
		assertTrue("Le brelan est supérieur à une carte seule.", Combinaison.BRELAN.compareTo(Combinaison.CARTE) > 0);
		assertTrue("Le carre est inférieur à une quinte flush.", Combinaison.CARRE.compareTo(Combinaison.QUINTE_FLUSH) < 0);
		assertTrue("Le full est égal au full.", Combinaison.FULL.compareTo(Combinaison.FULL) == 0);
		assertTrue("Le full est égal au full.", Combinaison.FULL.equals(Combinaison.FULL));
	}

	@Test
	public void testValuesSort() {
		Combinaison combinaisonPrecedente = null;
		for (Combinaison comb : Combinaison.valuesDescendingSort()) {
			if (combinaisonPrecedente != null) {
				assertTrue("Chaque combinaison précédente est plus grande que la suivante.", combinaisonPrecedente.compareTo(comb) > 0);
			}
			combinaisonPrecedente = comb;
		}
	}
}
