package dad.atelier3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dad.atelier3.dao.RepoIndividuNewSchool;
import dad.atelier3.exception.SQLException;
import dad.atelier3.model.Individu;

@Service
public class ServiceIndividu {

	private static final String MESSAGE_ERREUR_SQL = "Problème SQL";

	@Autowired
	private RepoIndividuNewSchool repo;

	public Individu getIndividu(String refIndividu) {
		try {
			// Individu individu = repo.findByIdRef(refIndividu);
			// individu = individu == null ? repo.findByIdRef(refIndividu) : individu;
			// return (individu != null) ? individu : new Individu();
			return null;
		} catch (DataAccessException e) {
			throw new SQLException(MESSAGE_ERREUR_SQL, e);
		}
	}

	public Individu getInterimaire(String idInterimaire) {
		try {
			Individu individu = repo.findByIdInterimaire(idInterimaire);
			return (individu != null) ? individu : new Individu();
		} catch (DataAccessException e) {
			throw new SQLException(MESSAGE_ERREUR_SQL, e);
		}
	}

	public Individu getCandidat(String idCandidat) {
		try {
			Individu candidat = repo.findByIdCandidat(idCandidat);
			return (candidat != null) ? candidat : new Individu();
		} catch (DataAccessException e) {
			throw new SQLException(MESSAGE_ERREUR_SQL, e);
		}
	}
}
