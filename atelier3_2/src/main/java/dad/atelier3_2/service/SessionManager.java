package dad.atelier3_2.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import dad.atelier3_2.model.Session;

@Service
public class SessionManager {

	public Session getCurrentSession() {
		return new Session(RandomStringUtils.randomNumeric(3), RandomStringUtils.randomNumeric(3), RandomStringUtils.randomAlphanumeric(20));
	}

}
