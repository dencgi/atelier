package dad.atelier3.dao;

import dad.atelier3.model.Individu;

@FunctionalInterface
public interface RepoIndividu {

	Individu findByIdRef(String refIndividu);
}
