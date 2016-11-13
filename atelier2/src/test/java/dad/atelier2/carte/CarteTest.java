package dad.atelier2.carte;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarteTest {

	@Test
	public void testGetter() {
		Carte c = new Carte(Couleur.COEUR, Valeur.CINQ);
		assertEquals("Getter de la couleur", Couleur.COEUR, c.getCouleur());
		assertEquals("Getter de la valeur", Valeur.CINQ, c.getValeur());
	}
	
	@Test
	public void testCompareToValeur() {
		Carte c1 = new Carte(Couleur.COEUR, Valeur.DAME);
		Carte c2 = new Carte(Couleur.COEUR, Valeur.CINQ);
		assertTrue("c1 est plus grande que c2", c1.compareTo(c2) > 0);
	}
	
	@Test
	public void testCompareToCouleur() {
		Carte c1 = new Carte(Couleur.PIQUE, Valeur.CINQ);
		Carte c2 = new Carte(Couleur.COEUR, Valeur.CINQ);
		assertTrue("c1 est plus grande que c2", c1.compareTo(c2) > 0);
	}
	
	@Test
	public void testCompareTo() {
		Carte c1 = new Carte(Couleur.COEUR, Valeur.CINQ);
		Carte c2 = new Carte(Couleur.COEUR, Valeur.CINQ);
		assertTrue("c1 est égale à c2", c1.equals(c2));
		
		c1 = new Carte(Couleur.COEUR, Valeur.CINQ);
		c2 = new Carte(Couleur.COEUR, Valeur.CINQ);
		assertTrue("c1 est plus grande que c2", c1.compareTo(c2) == 0);
		
		c1 = new Carte(Couleur.CARREAU, Valeur.ROI);
		c2 = new Carte(Couleur.COEUR, Valeur.CINQ);
		assertTrue("c1 est plus grande que c2", c1.compareTo(c2) > 0);
		
		c1 = new Carte(Couleur.CARREAU, Valeur.ROI);
		c2 = new Carte(Couleur.COEUR, Valeur.ROI);
		assertTrue("c1 est plus grande que c2", c1.compareTo(c2) < 0);
	}

}
