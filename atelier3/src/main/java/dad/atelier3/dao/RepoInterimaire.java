package dad.atelier3.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoInterimaire implements RepoIndividu {

	@Override
	public Individu find(String refIndividu) {
		Individu interimaire = new Individu();
		interimaire.setIdRef(refIndividu);
		interimaire.setNom(RandomStringUtils.randomAlphabetic(8));
		interimaire.setType(Individu.Type.INTERIMAIRE);
		interimaire.setIdInterimaire(RandomStringUtils.randomAlphanumeric(15));

		return interimaire;
	}

}
