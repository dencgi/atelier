package dad.atelier2.carte;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabriqueCarteTest {

	@Test
	public void testValeur() {
		Valeur v1 = FabriqueCarte.getValeur();
		Valeur v2 = FabriqueCarte.getValeur();
		Valeur v3 = FabriqueCarte.getValeur();
		Valeur v4 = FabriqueCarte.getValeur();

		assertTrue("Certaines valeurs sont différentes", v1 != v2 || v1 != v3 || v1 != v4);
	}

	@Test
	public void testCouleur() {
		Couleur c1 = FabriqueCarte.getCouleur();
		Couleur c2 = FabriqueCarte.getCouleur();
		Couleur c3 = FabriqueCarte.getCouleur();
		Couleur c4 = FabriqueCarte.getCouleur();

		assertTrue("Certaines couleurs sont différentes", c1 != c2 || c1 != c3 || c1 != c4);
	}

	@Test
	public void testCarte() {
		Carte c1 = FabriqueCarte.getCarte();
		Carte c2 = FabriqueCarte.getCarte();
		Carte c3 = FabriqueCarte.getCarte();
		Carte c4 = FabriqueCarte.getCarte();

		assertTrue("Certaines cartes sont différentes", !c1.equals(c2) || !c1.equals(c3) || !c1.equals(c4));
	}
}
