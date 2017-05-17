package dad.atelier3.mock_rest_service_server;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_1 {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private RestTemplate restTemplate;
	private MockRestServiceServer mockServer;

	@Before
	public void init() {
		restTemplate = new RestTemplate();
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void testSimple() {
		String monRetour = "superchaine";
		mockServer.expect(ExpectedCount.once(), requestTo("/toto/1")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(monRetour, MediaType.APPLICATION_JSON));

		String result = restTemplate.getForObject("/toto/{id}", String.class, 1);

		assertEquals("Le retour n'est pas correct.", monRetour, result);
		mockServer.verify();
	}

	@Test
	public void testAppelsSuccessifs() {
		String monRetour1 = "superchaine1";
		String monRetour2 = "superchaine2";
		mockServer.expect(ExpectedCount.manyTimes(), requestTo("/toto/1")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(monRetour1, MediaType.APPLICATION_JSON));
		mockServer.expect(ExpectedCount.manyTimes(), requestTo("/toto/2")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(monRetour2, MediaType.APPLICATION_JSON));

		String r1 = restTemplate.getForObject("/toto/{id}", String.class, 1);
		String r2 = restTemplate.getForObject("/toto/{id}", String.class, 2);

		assertEquals("Les valeurs devraient être les mêmes.", r1, monRetour1);
		assertEquals("Les valeurs devraient être les mêmes.", r2, monRetour2);
		mockServer.verify();
	}

	@Test
	public void testAvecErreur() {
		mockServer.expect(ExpectedCount.manyTimes(), requestTo("/toto/1")).andExpect(method(HttpMethod.GET)).andRespond(withStatus(HttpStatus.NOT_FOUND));
		thrown.expect(HttpClientErrorException.class);
		thrown.expectMessage("404");

		restTemplate.getForObject("/toto/{id}", String.class, 1);

		mockServer.verify();
	}
}
