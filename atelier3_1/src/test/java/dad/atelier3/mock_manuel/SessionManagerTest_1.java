package dad.atelier3.mock_manuel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dad.atelier3.Vue;
import dad.atelier3.exception.OperationNotSupportedException;
import dad.atelier3.model.Individu;

/*
 * Tests "normaux".
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class SessionManagerTest_1 {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private Vue vue;

	@Before
	public void before() {
		vue.start();
	}

	@After
	public void after() {
		vue.done();
	}

	@Test(expected = OperationNotSupportedException.class)
	public void mauvaiseCommandeTest() {
		vue.traitement("fjdk-jklds-fdsk");
	}

	@Test
	public void mauvaiseCommandeTest_v2() {
		try {
			vue.traitement("fjdk-jklds-fdsk");
			// vue.traitement("int-nom-azerty");
			fail("Une exception devrait être jetée.");
		} catch (OperationNotSupportedException e) {
			assertTrue("Aucune exception n'a été jetée", true);
		}
	}

	@Test
	public void mauvaiseCommandeTest_v3() {
		thrown.expect(OperationNotSupportedException.class);
		thrown.expectMessage("La commande ne ressemble à rien.");
		vue.traitement("fjdk-jklds-fdsk");
	}

	@Test
	public void bonneCommandeInterimaireTest() {
		vue.traitement("int-nom-azerty");
		Individu ind1 = vue.getIndividu();
		vue.traitement("int-prenom-titi");
		Individu ind2 = vue.getIndividu();

		assertSame("Il s'agit d'un seul et même individu", ind1, ind2);
		assertEquals("Il s'agit d'un intérimaire", Individu.Type.INTERIMAIRE, vue.getIndividu().getType());
		assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
		assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	}

	@Test
	public void bonneCommandeCandidatTest() {
		vue.traitement("can-nom-azerty");
		Individu ind1 = vue.getIndividu();
		vue.traitement("can-prenom-titi");
		Individu ind2 = vue.getIndividu();

		assertSame("Il s'agit d'un seul et même individu", ind1, ind2);
		assertEquals("Il s'agit d'un candidat", Individu.Type.CANDIDAT, vue.getIndividu().getType());
		assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
		assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	}

}
