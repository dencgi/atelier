package dad.atelier3.mockito;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dad.atelier3.Vue;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

/*
 * Mock avec des matchers.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_2_MockSimple {

	@Resource
	@InjectMocks
	private Vue vue;

	@Resource
	@Mock
	private ServiceIndividu serviceIndividu;

	private static Individu monIndividu1;
	private static Individu monIndividu2;

	@BeforeClass
	public static void init() {
		monIndividu1 = new Individu();
		monIndividu1.setIdRef("maRef");
		monIndividu1.setNom("toto");
		monIndividu1.setPrenom("titi");
		monIndividu1.setType(Individu.Type.CANDIDAT);
		monIndividu1.setIdCandidat("idCandidat");
		monIndividu1.setIdInterimaire("idInterimaire");

		monIndividu2 = new Individu();
		monIndividu2.setIdRef("maRef");
		monIndividu2.setNom("Mock");
		monIndividu2.setPrenom("Ito");
		monIndividu2.setType(Individu.Type.INTERIMAIRE);
		monIndividu2.setIdCandidat("idCandidat");
		monIndividu2.setIdInterimaire("idInterimaire");
	}

	@Before
	public void mock() throws OperationNotSupportedException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void traitementRemplacerTest() throws OperationNotSupportedException {
		// when(serviceIndividu.remplacer(anyString(), eq("ma-premiere-commande"))).thenReturn(monIndividu);
		// when(serviceIndividu.remplacer(anyString(), eq("ma-seconde-commande"))).thenReturn(monIndividu);

		doReturn(monIndividu1).when(serviceIndividu).remplacer(anyString(), eq("ma-premiere-commande"));
		doReturn(monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-seconde-commande"));

		vue.start();

		vue.traitement("ma-premiere-commande");
		assertEquals("Le mock retourne l'individu1", monIndividu1, vue.getIndividu());

		vue.traitement("ma-seconde-commande");
		assertEquals("Le mock retourne l'individu2", monIndividu2, vue.getIndividu());

		vue.done();

		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

	@Test
	public void tropAppelTest() throws OperationNotSupportedException {
		doReturn(monIndividu1, monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu1, monIndividu2);

		// doReturn(monIndividu1).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));
		// doReturn(monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu1);
		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu2);

		vue.start();
		vue.traitement("ma-troisieme-commande");
		assertEquals("Le mock retourne l'individu1", monIndividu1, vue.getIndividu());

		vue.traitement("ma-troisieme-commande");
		assertEquals("Le mock retourne l'individu2", monIndividu2, vue.getIndividu());

		vue.done();

		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

}
