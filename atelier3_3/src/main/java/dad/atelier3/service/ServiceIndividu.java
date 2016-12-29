package dad.atelier3.service;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dad.atelier3.dao.RepoCandidat;
import dad.atelier3.dao.RepoInterimaire;
import dad.atelier3.exception.SQLException;
import dad.atelier3.model.Individu;

@Service
public class ServiceIndividu {

	private static final String MESSAGE_ERREUR_SQL = "Problème SQL";

	@Resource
	private RepoInterimaire repoInterimaire;

	@Resource
	private RepoCandidat repoCandidat;

	public Individu getIndividu(String refIndividu) {
		try {
			Individu individu = repoInterimaire.findByIdRef(refIndividu);
			individu = individu == null ? repoCandidat.findByIdRef(refIndividu) : individu;
			return (individu != null) ? individu : new Individu();
		} catch (DataAccessException e) {
			throw new SQLException(MESSAGE_ERREUR_SQL, e);
		}
	}

	public Individu getInterimaire(String idInterimaire) {
		try {
			Individu individu = repoInterimaire.findByIdInterimaire(idInterimaire);
			return (individu != null) ? individu : new Individu();
		} catch (DataAccessException e) {
			throw new SQLException(MESSAGE_ERREUR_SQL, e);
		}
	}

	public Individu getCandidat(String idCandidat) {
		try {
			Individu candidat = repoCandidat.findByIdCandidat(idCandidat);
			return (candidat != null) ? candidat : new Individu();
		} catch (DataAccessException e) {
			throw new SQLException(MESSAGE_ERREUR_SQL, e);
		}
	}
}
