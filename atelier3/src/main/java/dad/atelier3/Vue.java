package dad.atelier3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dad.atelier3.controller.MonControleur;
import dad.atelier3.dto.FormulaireDTO;

public class Vue {

	private ApplicationContext context;

	public static void main(String[] args) {
		Vue vue = new Vue();
		vue.context = new ClassPathXmlApplicationContext("application-context.xml");
		vue.start();
	}

	public void start() {
		FormulaireDTO form = new FormulaireDTO();
		form.setSessionId("sessionId-fdjlk");
		MonControleur controleur = context.getBean(MonControleur.class);
		controleur.traiterAction(form);
	}
}
