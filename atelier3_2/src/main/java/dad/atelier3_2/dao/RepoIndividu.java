package dad.atelier3_2.dao;

import dad.atelier3_2.model.Individu;

@FunctionalInterface
public interface RepoIndividu {

	Individu find(String refIndividu);
}
