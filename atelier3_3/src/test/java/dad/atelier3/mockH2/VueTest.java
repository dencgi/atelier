package dad.atelier3.mockH2;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import dad.atelier3.dao.RepoIndividuNewSchool;
import dad.atelier3.model.Individu;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VueTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private RepoIndividuNewSchool repo;

	@Before
	public void init() {
		repo.deleteAll();
		repo.deleteAll();

		Individu monCandidat = new Individu();
		monCandidat.setIdRef("1");
		monCandidat.setNom("toto");
		monCandidat.setPrenom("titi");
		monCandidat.setType(Individu.Type.CANDIDAT);
		monCandidat.setIdCandidat("1");
		monCandidat.setIdInterimaire(null);
		repo.saveAndFlush(monCandidat);

		Individu monInterimaire = new Individu();
		monInterimaire.setIdRef("2");
		monInterimaire.setNom("Mock");
		monInterimaire.setPrenom("Ito");
		monInterimaire.setType(Individu.Type.INTERIMAIRE);
		monInterimaire.setIdCandidat(null);
		monInterimaire.setIdInterimaire("1");
		repo.saveAndFlush(monInterimaire);
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
		assertEquals("Le nombre de données n'est pas correct", 2, repo.count());
		assertEquals("Le nombre de données n'est pas correct", 2, repo.count());
	}

	@Test
	public void plantageTest() throws Exception {
		Individu monIndividuEnTrop = new Individu();
		monIndividuEnTrop.setIdRef("3");
		monIndividuEnTrop.setNom("tata");
		monIndividuEnTrop.setPrenom("titi");
		monIndividuEnTrop.setType(Individu.Type.CANDIDAT);
		monIndividuEnTrop.setIdCandidat("1");
		monIndividuEnTrop.setIdInterimaire(null);
		repo.saveAndFlush(monIndividuEnTrop);

		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/candidat/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
		//@formatter:on
	}

}
