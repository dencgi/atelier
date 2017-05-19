package dad.atelier3.dao;

import java.util.List;

import dad.atelier3.model.Individu;

public interface RepoIndividu {

	Individu save(Individu individu);

	Individu find(String refId);

	Individu findByIdInterimaire(String idInterimaire);

	Individu findByIdCandidat(String idCandidat);

	List<Individu> findAllCandidat();

}
