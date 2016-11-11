package dad.atelier3.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dad.atelier3.dao.RepoCandidat;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_2_MockSimple {

	@Autowired
	private ServiceIndividu serviceIndividu;

	@Mock
	private RepoCandidat mockRepoCandidat;

	@Test
//	@Repeat(value = 10)
	public void serviceTest() {

		MockitoAnnotations.initMocks(this);

		// Création du Mock.
//		RepoCandidat mockRepoCandidat = new RepoCandidat() {
//			public Individu find(Individu candidatRecherche) {
//				candidatRecherche.setType(Individu.Type.INTERIMAIRE);
//				System.out.println("Dans le mock !");
//				return candidatRecherche;
//			}
//		};
//		mockRepoCandidat = Mockito.mock(RepoCandidat.class);
		Mockito.when(mockRepoCandidat.find(new Individu())).thenReturn(new Individu());
		
		// Injection du Mock.
		serviceIndividu.setRepoCandidat(mockRepoCandidat);

		Individu ind = serviceIndividu.find("idRef-489");
		Assert.assertNotNull("Individu ne doit pas être null !", ind);
		assertEquals("Le candidat n'est pas un interimaire !", Individu.Type.INTERIMAIRE, ind.getType());
	}

}
