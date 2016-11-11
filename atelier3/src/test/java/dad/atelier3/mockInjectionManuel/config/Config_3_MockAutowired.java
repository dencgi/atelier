package dad.atelier3.mockInjectionManuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dad.atelier3.dao.RepoCandidat;
import dad.atelier3.dao.RepoIndividu;
import dad.atelier3.dao.RepoInterimaire;
import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@Configuration
public class Config_3_MockAutowired {

	@Bean
	public RepoCandidat repoCandidat() {
		// Création du Mock.
		return new RepoCandidat() {
			@Override
			public Individu find(Individu candidatRecherche) {
				candidatRecherche.setType(Individu.Type.INTERIMAIRE);
				System.out.println("Dans le mock RepoCandidat !");
				return candidatRecherche;
			}
		};
	}

	@Bean
	public RepoInterimaire repoInterimaire() {
		// Création du Mock.
		return new RepoInterimaire() {
			@Override
			public Individu find(Individu candidatRecherche) {
				candidatRecherche.setType(Individu.Type.INTERIMAIRE);
				System.out.println("Dans le mock RepoInterimaire !");
				return candidatRecherche;
			}
		};
	}

	@Bean
	public RepoIndividu repoIndividu() {
		// Création du Mock.
		return new RepoIndividu() {
			@Override
			public Individu find(String candidatRecherche) {
				Individu ind = new Individu();
				ind.setType(Individu.Type.INTERIMAIRE);
				System.out.println("Dans le mock RepoIndividu !");
				return ind;
			}
		};
	}

	@Bean
	public ServiceIndividu serviceIndividu() {
		return new ServiceIndividu();
	}
}
