package dad.atelier2.table;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dad.atelier2.carte.Carte;
import dad.atelier2.carte.Couleur;
import dad.atelier2.carte.Valeur;
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

	@Test
	public void testDeterminerGagnant() {
		Croupier c = new Croupier();
		Joueur[] joueurs = new Joueur[] { new Joueur("toto"), new Joueur("tata"), new Joueur("titi") };
		for (Joueur j : joueurs) {
			c.accueillir(j);
		}
		c.distribuer();

		List<Joueur> gagnants = c.getGagnants();
		assertFalse("Il y a au moins un gagnant.", gagnants.isEmpty());
	}

	@Test
	public void testGagnantMainIdentique() {
		Croupier c = new Croupier();
		Joueur[] joueurs = new Joueur[] { new Joueur("toto"), new Joueur("tata"), new Joueur("titi") };
		for (Joueur j : joueurs) {
			c.accueillir(j);
			j.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.DIX));
			j.recevoirCarte(new Carte(Couleur.COEUR, Valeur.SIX));
			j.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.AS));
			j.recevoirCarte(new Carte(Couleur.TREFLE, Valeur.DIX));
			j.recevoirCarte(new Carte(Couleur.PIQUE, Valeur.DEUX));
		}

		List<Joueur> gagnants = c.getGagnants();
		assertEquals("Il y a trois gagnants.", 3, gagnants.size());
	}

	@Test
	public void testGagnantToto() {
		Croupier c = new Croupier();
		Joueur[] joueurs = new Joueur[] { new Joueur("toto"), new Joueur("tata"), new Joueur("titi") };
		
		Joueur toto = joueurs[0];
		toto.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.DIX));
		toto.recevoirCarte(new Carte(Couleur.COEUR, Valeur.DIX));
		toto.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.AS));
		toto.recevoirCarte(new Carte(Couleur.TREFLE, Valeur.DIX));
		toto.recevoirCarte(new Carte(Couleur.PIQUE, Valeur.DEUX));
		
		Joueur tata = joueurs[1];
		tata.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.DIX));
		tata.recevoirCarte(new Carte(Couleur.COEUR, Valeur.SIX));
		tata.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.AS));
		tata.recevoirCarte(new Carte(Couleur.TREFLE, Valeur.DIX));
		tata.recevoirCarte(new Carte(Couleur.PIQUE, Valeur.DEUX));
		
		Joueur titi = joueurs[2];
		titi.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.DIX));
		titi.recevoirCarte(new Carte(Couleur.COEUR, Valeur.SIX));
		titi.recevoirCarte(new Carte(Couleur.CARREAU, Valeur.AS));
		titi.recevoirCarte(new Carte(Couleur.TREFLE, Valeur.ROI));
		titi.recevoirCarte(new Carte(Couleur.PIQUE, Valeur.DEUX));

		for (Joueur j : joueurs) {
			c.accueillir(j);
		}

		List<Joueur> gagnants = c.getGagnants();
		assertEquals("Il y a un seul gagnant.", 1, gagnants.size());
		assertEquals("Le gagnant est toto.", "toto", gagnants.get(0).getNom());
	}

}
