package dad.atelier3.mockito;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dad.atelier3.Vue;
import dad.atelier3.service.ServiceIndividu;

/*
 * Mock vide avec mockito.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class VueTest_1 {

	@Resource
	@InjectMocks
	private Vue vue;

	@Resource
	@Mock
	private ServiceIndividu serviceIndividu;

	@Before
	public void mock() {
		MockitoAnnotations.initMocks(this);
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
