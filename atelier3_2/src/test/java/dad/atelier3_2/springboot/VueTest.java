package dad.atelier3_2.springboot;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VueTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void mauvaiseCommandeTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/?cmd=fjdk-jklds-fdsk").accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());
	}

	// @Test
	// public void bonneCommandeInterimaireTest() throws OperationNotSupportedException {
	// vue.start();
	// vue.traitement("int-nom-azerty");
	// Individu ind1 = vue.getIndividu();
	// vue.traitement("int-prenom-titi");
	// Individu ind2 = vue.getIndividu();
	// vue.done();
	//
	// assertSame("Il s'agit d'un seul et même individu", ind1, ind2);
	// assertEquals("Il s'agit d'un intérimaire", Individu.Type.INTERIMAIRE, vue.getIndividu().getType());
	// assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
	// assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	// }

	// @Test
	// public void bonneCommandeCandidatTest() throws OperationNotSupportedException {
	// vue.start();
	// vue.traitement("can-nom-azerty");
	// Individu ind1 = vue.getIndividu();
	// vue.traitement("can-prenom-titi");
	// Individu ind2 = vue.getIndividu();
	// vue.done();
	//
	// assertSame("Il s'agit d'un seul et même individu", ind1, ind2);
	// assertEquals("Il s'agit d'un candidat", Individu.Type.CANDIDAT, vue.getIndividu().getType());
	// assertEquals("Le nom a été remplacé", "azerty", vue.getIndividu().getNom());
	// assertEquals("Le prénom a été remplacé", "titi", vue.getIndividu().getPrenom());
	// }

}
