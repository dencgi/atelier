package dad.atelier3.springboot;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dad.atelier3.exception.MonException;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VueTest_2 {

	@Autowired
	private MockMvc mvc;

	@MockBean
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

	@Test
	public void traitementRemplacerTest() throws Exception {
		// when(serviceIndividu.remplacer(anyString(), eq("ma-premiere-commande"))).thenReturn(monIndividu);
		// when(serviceIndividu.remplacer(anyString(), eq("ma-seconde-commande"))).thenReturn(monIndividu);

		doReturn(monIndividu1).when(serviceIndividu).remplacer(anyString(), eq("ma-premiere-commande"));
		doReturn(monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-seconde-commande"));

		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=ma-premiere-commande").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.CANDIDAT.toString())))
				.andExpect(jsonPath("$.nom", is("toto")));
		
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=ma-seconde-commande").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.INTERIMAIRE.toString())))
				.andExpect(jsonPath("$.nom", is("Mock")));
		//@formatter:on

		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

	@Test
	public void appelSuccessifTest() throws Exception {
		// Ne fonctionne qu'à partir de Mockito 2.1.0. Avec springboot 1.4.0, la version de Mockito est la 1.10.19.
		// doReturn(monIndividu1, monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu1, monIndividu2);

		// doReturn(monIndividu1).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));
		// doReturn(monIndividu2).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu1);
		// when(serviceIndividu.remplacer(anyString(), eq("ma-troisieme-commande"))).thenReturn(monIndividu2);

		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=ma-troisieme-commande").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.CANDIDAT.toString())))
				.andExpect(jsonPath("$.nom", is("toto")));
		
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=ma-troisieme-commande").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.INTERIMAIRE.toString())))
				.andExpect(jsonPath("$.nom", is("Mock")));
		//@formatter:on

		verify(serviceIndividu, times(2)).remplacer(any(), any());
	}

	@Test(expected = MonException.class)
	public void exceptionTest() throws Exception {
		doThrow(new MonException()).when(serviceIndividu).remplacer(anyString(), eq("ma-troisieme-commande"));

		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=ma-troisieme-commande").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadGateway());
		//@formatter:on

		verify(serviceIndividu, times(1)).remplacer(any(), any());
	}

	@Test
	public void captureTest() throws Exception {
		ArgumentCaptor<String> refIndividuCaptor = ArgumentCaptor.forClass(String.class);
		doReturn(monIndividu1).when(serviceIndividu).remplacer(refIndividuCaptor.capture(), anyString());

		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=encore-une-commande").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		//@formatter:on

		System.out.println(refIndividuCaptor.getValue());
	}

}
