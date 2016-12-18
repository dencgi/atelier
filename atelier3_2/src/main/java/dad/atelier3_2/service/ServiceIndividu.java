package dad.atelier3_2.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;

import org.springframework.stereotype.Service;

import dad.atelier3_2.dao.RepoCandidat;
import dad.atelier3_2.dao.RepoIndividu;
import dad.atelier3_2.dao.RepoInterimaire;
import dad.atelier3_2.model.Individu;

@Service
public class ServiceIndividu {

	private static final String MESSAGE_ERREUR = "La commande ne ressemble à rien.";
	private static final String GROUPE_REPO = "repo";
	private static final String GROUPE_ATTRIBUT = "att";
	private static final String GROUPE_VALEUR = "valeur";
	private static final Pattern PATTERN_COMMANDE = Pattern.compile("^(?<" + GROUPE_REPO + ">int|can)-(?<" + GROUPE_ATTRIBUT + ">\\w+)-(?<" + GROUPE_VALEUR + ">\\w+)$");

	@Resource
	private RepoInterimaire repoInterimaire;

	@Resource
	private RepoCandidat repoCandidat;

	private RepoIndividu getRepo(String commande) throws OperationNotSupportedException {
		Matcher m = PATTERN_COMMANDE.matcher(commande);
		if (!m.matches()) {
			throw new OperationNotSupportedException(MESSAGE_ERREUR);
		}
		return "int".equals(m.group(GROUPE_REPO)) ? repoInterimaire : repoCandidat;
	}

	private String getNomAttribut(String commande) throws OperationNotSupportedException {
		Matcher m = PATTERN_COMMANDE.matcher(commande);
		if (!m.matches()) {
			throw new OperationNotSupportedException(MESSAGE_ERREUR);
		}
		return m.group(GROUPE_ATTRIBUT);
	}

	private String getValeur(String commande) throws OperationNotSupportedException {
		Matcher m = PATTERN_COMMANDE.matcher(commande);
		if (!m.matches()) {
			throw new OperationNotSupportedException(MESSAGE_ERREUR);
		}
		return m.group(GROUPE_VALEUR);
	}

	public Individu remplacer(String refIndividu, String commande) throws OperationNotSupportedException {
		Individu individu = getRepo(commande).find(refIndividu);
		// Dans le cas où aucun individu n'est trouvé.
		if (individu == null) {
			return null;
		}
		if ("nom".equals(getNomAttribut(commande))) {
			individu.setNom(getValeur(commande));
		}
		if ("prenom".equals(getNomAttribut(commande))) {
			individu.setPrenom(getValeur(commande));
		}
		return individu;
	}

	public Individu ajouter(String refIndividu, String commande) throws OperationNotSupportedException {
		Individu individu = getRepo(commande).find(refIndividu);
		// Dans le cas où aucun individu n'est trouvé.
		if (individu == null) {
			return null;
		}
		if ("nom".equals(getNomAttribut(commande))) {
			individu.setNom(individu.getNom() + getValeur(commande));
		}
		if ("prenom".equals(getNomAttribut(commande))) {
			individu.setPrenom(individu.getPrenom() + getValeur(commande));
		}
		return individu;
	}

}
