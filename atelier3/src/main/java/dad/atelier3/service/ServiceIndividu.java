package dad.atelier3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dad.atelier3.dao.RepoCandidat;
import dad.atelier3.dao.RepoIndividu;
import dad.atelier3.dao.RepoInterimaire;
import dad.atelier3.model.Individu;

@Service
public class ServiceIndividu {

	@Autowired
	private RepoIndividu repoIndividu;

	@Autowired
	private RepoInterimaire repoInterimaire;

	@Autowired
	private RepoCandidat repoCandidat;

	public Individu find(String idRef) {
		Individu ind = repoIndividu.find(idRef);
		if (ind.getType() == Individu.Type.INTERIMAIRE) {
			ind = repoInterimaire.find(ind);
		} else {
			ind = repoCandidat.find(ind);
		}
		return ind;
	}

	public void setRepoIndividu(RepoIndividu repoIndividu) {
		this.repoIndividu = repoIndividu;
	}

	public void setRepoInterimaire(RepoInterimaire repoInterimaire) {
		this.repoInterimaire = repoInterimaire;
	}

	public void setRepoCandidat(RepoCandidat repoCandidat) {
		this.repoCandidat = repoCandidat;
	}

}
