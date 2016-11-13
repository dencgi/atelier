package dad.atelier2.carte;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValeurTest {

	@Test
	public void test() {
		Valeur v1 = Valeur.tirerAuHasard();
		Valeur v2 = Valeur.tirerAuHasard();
		Valeur v3 = Valeur.tirerAuHasard();
		Valeur v4 = Valeur.tirerAuHasard();

		assertTrue("Certaines valeurs sont différentes", v1 != v2 || v1 != v3 || v1 != v4);
	}

}
