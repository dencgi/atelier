package dad.atelier3.mock_manuel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import dad.atelier3.Vue;
import dad.atelier3.model.Individu;
import dad.atelier3.model.Session;
import dad.atelier3.service.SessionManager;

/*
 * Tests avec un mock fait main.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class SessionManagerTest_2_MockSimple {

	@Autowired
	private Vue vue;

	@PostConstruct
	public void mock() {
		SessionManager sessionManagerMock = new SessionManager() {
			public Session getCurrentSession() {
				return new Session("132", null, RandomStringUtils.randomAlphanumeric(20));
			}
		};
		ReflectionTestUtils.setField(vue, "sessionManager", sessionManagerMock);
	}

	@Before
	public void before() {
		vue.start();
	}

	@After
	public void after() {
		vue.done();
	}

	@Test
	public void bonneCommandeInterimaireTest() {
		vue.traitement("int-nom-azerty");
		vue.traitement("int-prenom-titi");

		assertEquals("Il s'agit d'un intérimaire", Individu.Type.INTERIMAIRE, vue.getIndividu().getType());
		assertNotEquals("Le nom n'a pas été remplacé", "azerty", vue.getIndividu().getNom());
		assertNotEquals("Le nom n'a pas été remplacé", "titi", vue.getIndividu().getPrenom());
		assertTrue("Le nom a été ajouté", vue.getIndividu().getNom().endsWith("azerty"));
		assertTrue("Le prénom a été ajouté", vue.getIndividu().getPrenom().endsWith("titi"));
	}

}
