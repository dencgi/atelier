package dad.atelier3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dad.atelier3.model.Individu;

public interface RepoCandidat extends RepoIndividu, JpaRepository<Individu, String> {

	@Query("from Individu i where i.type = 1 and i.idCandidat = ?1")
	Individu findByIdCandidat(String idCandidat);
}
