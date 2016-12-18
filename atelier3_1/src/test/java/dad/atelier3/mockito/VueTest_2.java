package dad.atelier3.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dad.atelier3.Vue;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

/*
 * Mock avec des matchers.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class VueTest_2 {

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
	public void mock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void traitementRemplacerTest() {
		// when(serviceIndividu.remplacer(anyString(), eq("ma-premiere-commande"))).thenReturn(monIndividu);
		// when(serviceIndividu.remplacer(anyString(), eq("ma-seconde-commande"))).thenReturn(monIndividu);

		doReturn(monIndividu1).when(serviceIndividu).remplacer(anyString(), eq("ma-premiere-commande"));
		doReturn(monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-seconde-commande"));

		vue.start();
		vue.traitement("ma-premiere-commande");
		Individu premierIndividu = vue.getIndividu();
		vue.traitement("ma-seconde-commande");
		Individu secondIndividu = vue.getIndividu();
		vue.done();

		assertEquals("Le mock retourne l'individu1", monIndividu1, premierIndividu);
		assertEquals("Le mock retourne l'individu2", monIndividu2, secondIndividu);
		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

	@Test
	public void appelSuccessifTest() {
		doReturn(monIndividu1, monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu1, monIndividu2);

		// doReturn(monIndividu1).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));
		// doReturn(monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu1);
		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu2);

		vue.start();
		vue.traitement("ma-troisieme-commande");
		Individu premierAppel = vue.getIndividu();
		vue.traitement("ma-troisieme-commande");
		Individu secondAppel = vue.getIndividu();
		vue.done();

		assertEquals("Le mock retourne l'individu1", monIndividu1, premierAppel);
		assertEquals("Le mock retourne l'individu2", monIndividu2, secondAppel);
		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

	@Test(expected = IllegalArgumentException.class)
	public void exceptionTest() {
		doThrow(new IllegalArgumentException()).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		vue.start();
		vue.traitement("ma-troisieme-commande");
		vue.traitement("ma-troisieme-commande");
		vue.done();

		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

	@Test
	public void captureTest() {
		ArgumentCaptor<String> refIndividuCaptor = ArgumentCaptor.forClass(String.class);
		doReturn(monIndividu1).when(serviceIndividu).remplacer(refIndividuCaptor.capture(), anyString());

		vue.start();
		vue.traitement("encore-une-commande");
		vue.done();

		System.out.println(refIndividuCaptor.getValue());
	}

}
