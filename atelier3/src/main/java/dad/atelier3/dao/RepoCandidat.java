package dad.atelier3.dao;

import org.springframework.stereotype.Repository;

import dad.atelier3.model.Individu;

@Repository
public class RepoCandidat {

	public Individu find(Individu candidatRecherche) {
		String idCandidat = candidatRecherche.getIdCandidat();
		// On fait plein de choses avec l'idCandidat, comme recherché en base.
		System.out.println("On fait plein de choses avec l'idCandidat : " + idCandidat);

		Individu candidatTrouve = new Individu(candidatRecherche);
		candidatTrouve.setNom("Candidat");
		candidatTrouve.setType(Individu.Type.CANDIDAT);
		return candidatTrouve;
	}
}
