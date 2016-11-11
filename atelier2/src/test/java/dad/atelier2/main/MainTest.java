package dad.atelier2.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.combinaison.Combinaison;
import dad.atelier2.exception.MainPleineException;
import dad.atelier2.joueur.Main;

public class MainTest {

	@Test
	public void testCarre() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		assertEquals("Problème lors de la détection du carré !", "CARRE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testQuinteFlush() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection du carré !", "QUINTE_FLUSH", Combinaison.getCombinaison(main));
	}

	@Test
	public void testCouleur() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection du carré !", "COULEUR", Combinaison.getCombinaison(main));
	}

	@Test
	public void testBrelan() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.PIQUE, Valeur.VALET));
		main.add(new Carte(Couleur.COEUR, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection du carré !", "BRELAN", Combinaison.getCombinaison(main));
	}

	@Test
	public void testCarte() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection du carré !", "CARTE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testDoublePaire() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.CARREAU, Valeur.ROI));
		assertEquals("Problème lors de la détection du carré !", "DOUBLE_PAIRE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testFull() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.add(new Carte(Couleur.CARREAU, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.COEUR, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		assertEquals("Problème lors de la détection du carré !", "FULL", Combinaison.getCombinaison(main));
	}

	@Test
	public void testSuite() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.PIQUE, Valeur.HUIT));
		assertEquals("Problème lors de la détection du carré !", "SUITE", Combinaison.getCombinaison(main));
	}

	@Test(expected = MainPleineException.class)
	public void testMainPleine() throws MainPleineException {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.PIQUE, Valeur.HUIT));
		main.add(new Carte(Couleur.CARREAU, Valeur.NEUF));
	}

}
