package dad.atelier1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dad.atelier1.constructeur.CleVoiture;
import dad.atelier1.constructeur.peugeot.ModelePeugeot;
import dad.atelier1.constructeur.renault.ModeleRenault;
import dad.atelier1.voiture.Voiture;

@Component
public class App {

	@Autowired
	private Concessionnaire concessionnaire;

	@Value(value = "${app.go}")
	private String go;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		App app = context.getBean(App.class);
		app.start();
	}

	public void start() {
		System.out.println(go);

		CleVoiture maCleVoiture = concessionnaire.commanderVoiture(ModelePeugeot.P305);
		Voiture maCleVoitureDeSecours = concessionnaire.commanderVoiture(ModelePeugeot.P305).getVoiture();
		Voiture maRenault = concessionnaire.commanderVoiture(ModeleRenault.R5).getVoiture();
		System.out.println(maCleVoiture.getVoiture());
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().remplirReservoir(70);
		maCleVoiture.getVoiture().demarrer(maCleVoiture.getCle());
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().rouler(200);
		maCleVoiture.getVoiture().rouler(200);
		System.out.println(maCleVoiture.getVoiture());
		System.out.println(maCleVoitureDeSecours);
		System.out.println(maRenault);
	}
}
