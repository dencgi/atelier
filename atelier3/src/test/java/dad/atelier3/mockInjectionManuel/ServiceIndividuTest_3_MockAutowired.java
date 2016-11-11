package dad.atelier3.mockInjectionManuel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dad.atelier3.mockInjectionManuel.config.Config_3_MockAutowired;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config_3_MockAutowired.class)
public class ServiceIndividuTest_3_MockAutowired {

	@Autowired
	private ServiceIndividu serviceIndividu;

	@Test
	@Repeat(value = 10)
	public void serviceTest() {
		Individu ind = serviceIndividu.find("idRef-489");
		assertEquals("Le candidat n'est pas un interimaire !", Individu.Type.INTERIMAIRE, ind.getType());
	}

}
