package dad.atelier3.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoInterimaire implements RepoIndividu {

	private Map<String, Individu> cache = new HashMap<>();

	@Override
	public Individu find(String refIndividu) {
		if (!cache.containsKey(refIndividu)) {
			Individu interimaire = new Individu();
			interimaire.setIdRef(refIndividu);
			interimaire.setNom(RandomStringUtils.randomAlphabetic(8));
			interimaire.setPrenom(RandomStringUtils.randomAlphabetic(6));
			interimaire.setType(Individu.Type.INTERIMAIRE);
			interimaire.setIdInterimaire(RandomStringUtils.randomAlphanumeric(15));
			cache.put(refIndividu, interimaire);
		}

		return cache.get(refIndividu);
	}

}
