package dad.atelier3.dao;

import dad.atelier3.model.Individu;

@FunctionalInterface
public interface RepoIndividu {

	Individu find(String refIndividu);
}
