package dad.atelier3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository("repoOldSchool")
public class RepoIndividuOldSchool implements RepoIndividu {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Individu find(String idRef) {
		TypedQuery<Individu> query = em.createQuery("FROM Individu WHERE idRef = :idRef", Individu.class);
		query.setParameter("idRef", idRef);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Individu save(Individu individu) {
		return em.merge(individu);
	}

	@Override
	public Individu findByIdInterimaire(String idInterimaire) {
		TypedQuery<Individu> query = em.createQuery("FROM Individu WHERE idInterimaire = :id", Individu.class);
		query.setParameter("id", idInterimaire);
		return query.getSingleResult();
	}

	@Override
	public Individu findByIdCandidat(String idCandidat) {
		TypedQuery<Individu> query = em.createQuery("FROM Individu WHERE idCandidat = :id", Individu.class);
		query.setParameter("id", idCandidat);
		return query.getSingleResult();
	}
	
	@Override
	public List<Individu> findAllCandidat() {
		TypedQuery<Individu> query = em.createQuery("FROM Individu WHERE type = :type", Individu.class);
		query.setParameter("type", Individu.Type.CANDIDAT);
		return query.getResultList();
	}

}
