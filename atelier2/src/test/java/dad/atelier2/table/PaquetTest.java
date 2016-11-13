package dad.atelier2.table;

import static org.junit.Assert.*;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
import dad.atelier2.exception.PaquetVideException;

public class PaquetTest {

	@Test
	public void testPaquetPlein() {
		Paquet p = new Paquet();
		assertTrue("Le paquet est plein.", p.isPlein());
	}

	@Test
	public void testPaquetApresTirage() {
		Paquet p = new Paquet();
		p.tirerCarte();
		assertFalse("Le paquet n'est pas plein.", p.isPlein());
	}

	@Test
	public void testTirageComplet() {
		Paquet p = new Paquet();
		assertTrue("Le paquet est plein.", p.isPlein());
		int tailleMax = Valeur.values().length * Couleur.values().length;
		for (int i = 0; i < tailleMax; ++i) {
			p.tirerCarte();
		}
		assertTrue("Le paquet est vide.", p.isVide());
	}

	@Test(expected = PaquetVideException.class)
	public void testTirageSansLimite() {
		Paquet p = new Paquet();
		assertTrue("Le paquet est plein.", p.isPlein());
		int tailleMax = Valeur.values().length * Couleur.values().length;
		for (int i = 0; i < tailleMax * 2; ++i) {
			p.tirerCarte();
		}
	}

	@Test
	public void testTirageAleatoire() {
		Paquet p = new Paquet();
		Carte c1 = p.tirerCarte();
		Carte c2 = p.tirerCarte();
		Carte c3 = p.tirerCarte();
		Carte c4 = p.tirerCarte();

		assertFalse("Les cartes ne sont pas triées.", c1.compareTo(c2) < 0 && c2.compareTo(c3) < 0 && c3.compareTo(c4) < 0);
	}
}
