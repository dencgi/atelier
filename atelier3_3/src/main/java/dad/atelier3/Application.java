package dad.atelier3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dad.atelier3.dao.RepoIndividuNewSchool;
import dad.atelier3.model.Individu;

// TODO : comment interroger une table qui n'existe pas ?
// TODO : comment faire une requête avec une colonne qui n'existe pas ?
// TODO : comment obtenir des erreurs pour tester les problèmes SQL ?
// TODO : montrer les différentes fonctionnalités de JpaRepository.
// TODO : montrer comment faire sans JpaRepository, pour voir les avantages que procure l'outil.

@SpringBootApplication
public class Application { // NOSONAR

	@Autowired
	private RepoIndividuNewSchool repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); // NOSONAR
	}

	@PostConstruct
	public void init() {
		Individu monIndividu1 = new Individu();
		monIndividu1.setIdRef("1");
		monIndividu1.setNom("toto");
		monIndividu1.setPrenom("titi");
		monIndividu1.setType(Individu.Type.CANDIDAT);
		monIndividu1.setIdCandidat("1");
		monIndividu1.setIdInterimaire(null);
		repo.saveAndFlush(monIndividu1);

		Individu monIndividu2 = new Individu();
		monIndividu2.setIdRef("2");
		monIndividu2.setNom("Mock");
		monIndividu2.setPrenom("Ito");
		monIndividu2.setType(Individu.Type.INTERIMAIRE);
		monIndividu2.setIdCandidat(null);
		monIndividu2.setIdInterimaire("1");
		repo.saveAndFlush(monIndividu2);
	}
}
