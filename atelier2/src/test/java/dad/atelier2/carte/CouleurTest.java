package dad.atelier2.carte;

import static org.junit.Assert.*;

import org.junit.Test;

public class CouleurTest {

	@Test
	public void test() {
		Couleur c1 = Couleur.tirerAuHasard();
		Couleur c2 = Couleur.tirerAuHasard();
		Couleur c3 = Couleur.tirerAuHasard();
		Couleur c4 = Couleur.tirerAuHasard();

		assertTrue("Certaines couleurs sont différentes", c1 != c2 || c1 != c3 || c1 != c4);
	}

}
