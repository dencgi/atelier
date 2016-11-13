package dad.atelier3;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dad.atelier3.model.Individu;
import dad.atelier3.model.Session;
import dad.atelier3.service.ServiceIndividu;
import dad.atelier3.service.SessionManager;

@Component
public class Vue {

	@Resource
	private SessionManager sessionManager;

	@Resource
	private ServiceIndividu serviceIndividu;

	private Session session;
	private Individu individu;

	public static void main(String[] args) throws OperationNotSupportedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Vue vue = context.getBean(Vue.class);
		vue.start();
		vue.traitement("int-nom-toto");
		vue.done();

		System.out.println(vue.individu);
	}

	private void start() {
		session = sessionManager.getCurrentSession();
	}

	private void traitement(String commande) throws OperationNotSupportedException {
		if (session.isInPopin()) {
			individu = serviceIndividu.ajouter(session.getRefIndividu(), commande);
		} else {
			individu = serviceIndividu.remplacer(session.getRefIndividu(), commande);
		}
	}

	private void done() {
		// Rien à faire.
	}
}
