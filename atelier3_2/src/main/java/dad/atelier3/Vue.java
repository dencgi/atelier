package dad.atelier3;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dad.atelier3.model.Individu;
import dad.atelier3.model.Session;
import dad.atelier3.service.ServiceIndividu;
import dad.atelier3.service.SessionManager;

// TODO : Ajouter des tests avec la base h2.
// TODO : Ajouter des tests pour mocker tout un service.

@RestController
public class Vue {

	@Resource
	private SessionManager sessionManager;

	@Resource
	private ServiceIndividu serviceIndividu;

	private Session session;
	private Individu individu;

	@RequestMapping("/")
	public Individu page(@RequestParam(value = "cmd", required = true) String commande) {
		start();
		traitement(commande);
		done();

		return individu;
	}

	public void start() {
		session = sessionManager.getCurrentSession();
		individu = null;
	}

	public void traitement(String commande) {
		if (session.isInPopin()) {
			individu = serviceIndividu.ajouter(session.getRefIndividu(), commande);
		} else {
			individu = serviceIndividu.remplacer(session.getRefIndividu(), commande);
		}
	}

	public void done() {
		// Rien à faire.
	}

}
