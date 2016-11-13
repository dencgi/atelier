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
import dad.atelier3.service.ServiceIndividu;


/*
 * Mock vide.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class ServiceIndividuTest_1 {

	@Autowired
	private Vue vue;
	
	@Autowired
	private ApplicationContext context;
	
	@Before
	public void injectMock() {
		ServiceIndividu mock = context.getBean(ServiceIndividuMock.class);
		ReflectionTestUtils.setField(vue, "serviceIndividu", mock);
	}

	@Test
	public void traitementReplaceTest() throws OperationNotSupportedException {
		vue.start();
		vue.traitement("int-nom-toto");
		vue.traitement("int-prenom-titi");
		vue.done();

		assertNull("Il n'y a pas d'individu car le mock ne fait rien", vue.getIndividu());
	}

}
