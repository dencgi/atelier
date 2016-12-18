package dad.atelier3.mock_spy;

import static org.junit.Assert.assertNotNull;

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
 * Spy vide.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class VueTest_2 {

	@Autowired
	private Vue vue;

	@Autowired
	private ApplicationContext context;

	@Before
	public void injectSpy() {
		ServiceIndividu spy = context.getBean(ServiceIndividuSpy.class);
		ReflectionTestUtils.setField(vue, "serviceIndividu", spy);
	}

	@Test
	public void traitementReplaceTest() {
		vue.start();
		vue.traitement("int-nom-toto");
		vue.traitement("int-prenom-titi");
		vue.done();

		assertNotNull("Il y a un individu car le spy, par défaut, fait pareil que l'objet réel", vue.getIndividu());
	}

}
