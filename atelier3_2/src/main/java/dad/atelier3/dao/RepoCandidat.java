package dad.atelier3.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoCandidat implements RepoIndividu {

	private Map<String, Individu> cache = new HashMap<>();

	@Override
	public Individu find(String refIndividu) {
		if (!cache.containsKey(refIndividu)) {
			Individu candidat = new Individu();
			candidat.setIdRef(refIndividu);
			candidat.setNom(RandomStringUtils.randomAlphabetic(8));
			candidat.setPrenom(RandomStringUtils.randomAlphabetic(6));
			candidat.setType(Individu.Type.CANDIDAT);
			candidat.setIdCandidat(RandomStringUtils.randomAlphanumeric(15));
			cache.put(refIndividu, candidat);
		}

		return cache.get(refIndividu);
	}

}
