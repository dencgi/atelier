package dad.atelier3.stubH2;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dad.atelier3.dao.RepoCandidat;
import dad.atelier3.dao.RepoInterimaire;
import dad.atelier3.model.Individu;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VueTest {

	@Autowired
	private MockMvc mvc;

	@Resource
	private RepoCandidat repoCandidat;

	@Resource
	private RepoInterimaire repoInterimaire;

	@Before
	public void init() {
		repoCandidat.deleteAll();
		repoInterimaire.deleteAll();

		Individu monCandidat = new Individu();
		monCandidat.setIdRef("1");
		monCandidat.setNom("toto");
		monCandidat.setPrenom("titi");
		monCandidat.setType(Individu.Type.CANDIDAT);
		monCandidat.setIdCandidat("1");
		monCandidat.setIdInterimaire(null);
		repoCandidat.saveAndFlush(monCandidat);

		Individu monInterimaire = new Individu();
		monInterimaire.setIdRef("2");
		monInterimaire.setNom("Mock");
		monInterimaire.setPrenom("Ito");
		monInterimaire.setType(Individu.Type.INTERIMAIRE);
		monInterimaire.setIdCandidat(null);
		monInterimaire.setIdInterimaire("1");
		repoInterimaire.saveAndFlush(monInterimaire);
	}

	@Test
	public void getIndividuTest() throws Exception {
		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/individu/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.CANDIDAT.toString())))
				.andExpect(jsonPath("$.nom", is("toto")));
		
		mvc.perform(MockMvcRequestBuilders.get("/individu/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.INTERIMAIRE.toString())))
				.andExpect(jsonPath("$.nom", is("Mock")));
		//@formatter:on
	}

	@Test
	public void getInterimaireTest() throws Exception {
		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/interimaire/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.INTERIMAIRE.toString())))
				.andExpect(jsonPath("$.nom", is("Mock")));
		//@formatter:on
	}

	@Test
	public void getCandidatTest() throws Exception {
		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/candidat/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.CANDIDAT.toString())))
				.andExpect(jsonPath("$.nom", is("toto")));
		//@formatter:on
	}

	@Test
	public void countTest() {
		assertEquals("Le nombre de données n'est pas correct", 2, repoCandidat.count());
		assertEquals("Le nombre de données n'est pas correct", 2, repoInterimaire.count());
	}

	@Test
	public void plantageTest() throws Exception {
		Individu monmonIndividuEnTrop = new Individu();
		monmonIndividuEnTrop.setIdRef("3");
		monmonIndividuEnTrop.setNom("tata");
		monmonIndividuEnTrop.setPrenom("titi");
		monmonIndividuEnTrop.setType(Individu.Type.CANDIDAT);
		monmonIndividuEnTrop.setIdCandidat("1");
		monmonIndividuEnTrop.setIdInterimaire(null);
		repoCandidat.saveAndFlush(monmonIndividuEnTrop);

		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/candidat/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
		//@formatter:on
	}

}
