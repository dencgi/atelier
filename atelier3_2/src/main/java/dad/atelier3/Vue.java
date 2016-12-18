package dad.atelier3_2;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dad.atelier3_2.model.Individu;
import dad.atelier3_2.model.Session;
import dad.atelier3_2.service.ServiceIndividu;
import dad.atelier3_2.service.SessionManager;

@RestController
public class Vue {

	@Resource
	private SessionManager sessionManager;

	@Resource
	private ServiceIndividu serviceIndividu;

	private Session session;
	private Individu individu;

	@RequestMapping("/")
	public String page(@RequestParam(value = "cmd", required = true) String commande) throws OperationNotSupportedException {
		start();
		traitement(commande);
		done();

		return individu.toString();
	}

	public void start() {
		session = sessionManager.getCurrentSession();
		individu = null;
	}

	public void traitement(String commande) throws OperationNotSupportedException {
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
