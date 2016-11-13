package dad.atelier3.mockInjectionManuel;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dad.atelier3.Vue;
import dad.atelier3.model.Individu;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_1 {

	@Autowired
	private Vue vue;

	@Test(expected = OperationNotSupportedException.class)
	public void mauvaiseCommandeTest() throws OperationNotSupportedException {
		vue.start();
		vue.traitement("fjdk-jklds-fdsk");
		vue.done();
	}

	@Test
	public void bonneCommandeInterimaireTest() throws OperationNotSupportedException {
		vue.start();
		vue.traitement("int-nom-azerty");
		vue.traitement("int-prenom-titi");
		vue.done();

		assertEquals("Il s'agit d'un intérimaire", Individu.Type.INTERIMAIRE, vue.getIndividu().getType());
		assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
		assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	}
	
	@Test
	public void bonneCommandeCandidatTest() throws OperationNotSupportedException {
		vue.start();
		vue.traitement("can-nom-azerty");
		vue.traitement("can-prenom-titi");
		vue.done();

		assertEquals("Il s'agit d'un candidat", Individu.Type.CANDIDAT, vue.getIndividu().getType());
		assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
		assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	}

}
