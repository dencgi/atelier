package dad.atelier3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository("repoNewSchool")
public interface RepoIndividuNewSchool extends JpaRepository<Individu, String> {

	Individu findByIdInterimaire(String idInterimaire);

	Individu findByIdCandidat(String idCandidat);

	@Query(value = "FROM Individu WHERE type = 1")
	List<Individu> findAllCandidat();
}
