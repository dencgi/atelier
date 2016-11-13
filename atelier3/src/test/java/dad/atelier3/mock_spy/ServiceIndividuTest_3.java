package dad.atelier3.mock_spy;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import dad.atelier3.Vue;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

/*
 * Mock surchargé.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_3 {

	@Autowired
	private Vue vue;
	
	@Autowired
	private ApplicationContext context;
	
	private Individu monIndividu;
	
	@Before
	public void injectMock() {
		ServiceIndividu mock = context.getBean(ServiceIndividuMock2.class);
		
		monIndividu = new Individu();
		monIndividu.setIdRef("maRef");
		monIndividu.setNom("toto");
		monIndividu.setPrenom("titi");
		monIndividu.setType(Individu.Type.CANDIDAT);
		monIndividu.setIdCandidat("idCandidat");
		monIndividu.setIdInterimaire("idInterimaire");
		
		ReflectionTestUtils.setField(vue, "serviceIndividu", mock);
		ReflectionTestUtils.setField(mock, "individu", monIndividu);
	}

	@Test
	public void traitementReplaceTest() throws OperationNotSupportedException {
		vue.start();
		vue.traitement("int-nom-toto");
		vue.traitement("int-prenom-titi");
		vue.done();

		assertEquals("Il s'agit du même individu", monIndividu, vue.getIndividu());
	}

}
