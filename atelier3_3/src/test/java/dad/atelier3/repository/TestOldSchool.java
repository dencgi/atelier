package dad.atelier3.repository;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import dad.atelier3.dao.RepoIndividu;
import dad.atelier3.model.Individu;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOldSchool {

	@Resource
	private RepoIndividu repoOldSchool;

	private Individu indDefaut;
	private static final String idIndividu = "1";
	private static final String idCandidat = "3";
	private static final String idInterimaire = "5";

	@Before
	public void init() {
		indDefaut = new Individu();
		indDefaut.setIdRef(idIndividu);
		indDefaut.setNom("toto");
		indDefaut.setPrenom("titi");
		indDefaut.setType(Individu.Type.CANDIDAT);
		indDefaut.setIdCandidat(idCandidat);
		indDefaut.setIdInterimaire(idInterimaire);

		repoOldSchool.save(indDefaut);
	}

	@Test
	public void testFind() {
		Individu tata = repoOldSchool.find(idIndividu);

		assertEquals("Les deux individus ne sont pas les mêmes.", indDefaut, tata);
	}

	@Test
	public void testFindInterimaire() {
		Individu tata = repoOldSchool.findByIdInterimaire(idInterimaire);

		assertEquals("Les deux individus ne sont pas les mêmes.", indDefaut, tata);
	}

	@Test
	public void testFindCandidat() {
		Individu tata = repoOldSchool.findByIdCandidat(idCandidat);

		assertEquals("Les deux individus ne sont pas les mêmes.", indDefaut, tata);
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindNotFound() {
		repoOldSchool.find("fhdsjk");
	}

}
