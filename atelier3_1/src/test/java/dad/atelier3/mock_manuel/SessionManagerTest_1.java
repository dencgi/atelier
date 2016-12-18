package dad.atelier3.mock_manuel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
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

	@Autowired
	private Vue vue;

	@Test(expected = OperationNotSupportedException.class)
	public void mauvaiseCommandeTest() {
		vue.start();
		vue.traitement("fjdk-jklds-fdsk");
		vue.done();
	}

	@Test
	public void bonneCommandeInterimaireTest() {
		vue.start();
		vue.traitement("int-nom-azerty");
		Individu ind1 = vue.getIndividu();
		vue.traitement("int-prenom-titi");
		Individu ind2 = vue.getIndividu();
		vue.done();

		assertSame("Il s'agit d'un seul et même individu", ind1, ind2);
		assertEquals("Il s'agit d'un intérimaire", Individu.Type.INTERIMAIRE, vue.getIndividu().getType());
		assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
		assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	}

	@Test
	public void bonneCommandeCandidatTest() {
		vue.start();
		vue.traitement("can-nom-azerty");
		Individu ind1 = vue.getIndividu();
		vue.traitement("can-prenom-titi");
		Individu ind2 = vue.getIndividu();
		vue.done();

		assertSame("Il s'agit d'un seul et même individu", ind1, ind2);
		assertEquals("Il s'agit d'un candidat", Individu.Type.CANDIDAT, vue.getIndividu().getType());
		assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
		assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	}

}
