package dad.atelier3;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Vue vue = context.getBean(Vue.class);
		vue.start();
		vue.traitement("int-nom-toto");
		vue.traitement("int-prenom-titi");
		vue.done();
		
		System.out.println(vue.individu);
		
		context.close();
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

	public Session getSession() {
		return session;
	}

	public Individu getIndividu() {
		return individu;
	}

}
