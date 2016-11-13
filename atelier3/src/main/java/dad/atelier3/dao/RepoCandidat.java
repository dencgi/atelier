package dad.atelier3.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoCandidat implements RepoIndividu {

	@Override
	public Individu find(String refIndividu) {
		Individu candidat = new Individu();
		candidat.setIdRef(refIndividu);
		candidat.setNom(RandomStringUtils.randomAlphabetic(8));
		candidat.setType(Individu.Type.CANDIDAT);
		candidat.setIdCandidat(RandomStringUtils.randomAlphanumeric(15));

		return candidat;
	}

}
