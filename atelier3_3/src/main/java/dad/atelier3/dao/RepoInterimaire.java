package dad.atelier3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dad.atelier3.model.Individu;

public interface RepoInterimaire extends RepoIndividu, JpaRepository<Individu, String> {

	@Query("from Individu i where i.type = 0 and i.idInterimaire = ?1")
	Individu findByIdInterimaire(String idInterimaire);
}
