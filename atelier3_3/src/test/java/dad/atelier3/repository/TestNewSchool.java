package dad.atelier3.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dad.atelier3.dao.RepoIndividuNewSchool;
import dad.atelier3.model.Individu;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestNewSchool {

	@Resource
	private RepoIndividuNewSchool repoNewSchool;

	private Individu i;
	private static final String idIndividu = "1";
	private static final String idCandidat = "3";
	private static final String idInterimaire = "5";

	@Before
	public void init() {
		i = new Individu();
		i.setIdRef(idIndividu);
		i.setNom("toto");
		i.setPrenom("titi");
		i.setType(Individu.Type.CANDIDAT);
		i.setIdCandidat(idCandidat);
		i.setIdInterimaire(idInterimaire);

		repoNewSchool.save(i);
	}

	@Test
	public void testFind() {
		Individu tata = repoNewSchool.findOne(idIndividu);

		assertEquals("Les deux individus ne sont pas les mêmes.", i, tata);
	}

	@Test
	public void testFindInterimaire() {
		Individu tata = repoNewSchool.findByIdInterimaire(idInterimaire);

		assertEquals("Les deux individus ne sont pas les mêmes.", i, tata);
	}

	@Test
	public void testFindCandidat() {
		Individu tata = repoNewSchool.findByIdCandidat(idCandidat);

		assertEquals("Les deux individus ne sont pas les mêmes.", i, tata);
	}

	@Test
	public void testFindNotFound() {
		Individu tata = repoNewSchool.findOne("fhdsjk");
		assertNull("Il n'y a pas d'individu.", tata);
	}

	@Test
	public void testEtc() {
		assertEquals("Il y a un candidat", 1, repoNewSchool.findAllCandidat().size());
		assertEquals("Il y en a un", 1, repoNewSchool.count());
		repoNewSchool.delete(idIndividu);
		assertEquals("Supprimé", 0, repoNewSchool.count());
	}

}
