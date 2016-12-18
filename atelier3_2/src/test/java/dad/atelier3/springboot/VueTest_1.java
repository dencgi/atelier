package dad.atelier3.springboot;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dad.atelier3.model.Individu;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VueTest_1 {

	@Autowired
	private MockMvc mvc;

	@Test
	public void mauvaiseCommandeTest() throws Exception {
		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=fjdk-jklds-fdsk").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
		//@formatter:on
	}

	@Test
	public void bonneCommandeInterimaireTest() throws Exception {
		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=int-nom-azerty").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.INTERIMAIRE.toString())))
				.andExpect(jsonPath("$.nom", is("azerty")));
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=int-prenom-titi").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.INTERIMAIRE.toString())))
				.andExpect(jsonPath("$.prenom", is("titi")));
		//@formatter:on
	}

	@Test
	public void bonneCommandeCandidatTest() throws Exception {
		//@formatter:off
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=can-nom-azerty").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.CANDIDAT.toString())))
				.andExpect(jsonPath("$.nom", is("azerty")));
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=can-prenom-titi").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.type", is(Individu.Type.CANDIDAT.toString())))
				.andExpect(jsonPath("$.prenom", is("titi")));
		//@formatter:on
	}

}
