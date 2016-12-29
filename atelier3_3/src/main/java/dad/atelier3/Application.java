package dad.atelier3;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dad.atelier3.dao.RepoCandidat;
import dad.atelier3.dao.RepoInterimaire;
import dad.atelier3.model.Individu;

@SpringBootApplication
public class Application { // NOSONAR

	@Resource
	private RepoCandidat repoCandidat;

	@Resource
	private RepoInterimaire repoInterimaire;

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
		repoCandidat.saveAndFlush(monIndividu1);

		Individu monIndividu2 = new Individu();
		monIndividu2.setIdRef("2");
		monIndividu2.setNom("Mock");
		monIndividu2.setPrenom("Ito");
		monIndividu2.setType(Individu.Type.INTERIMAIRE);
		monIndividu2.setIdCandidat(null);
		monIndividu2.setIdInterimaire("1");
		repoInterimaire.saveAndFlush(monIndividu2);
	}
}
