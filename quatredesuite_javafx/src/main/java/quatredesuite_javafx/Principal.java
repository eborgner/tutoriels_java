package quatredesuite_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
	
	static {

		Initialisateur.initialiser();

	}
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		launch(args);
	}
	
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/principal.xml");
		
		Scene scene = chargeur.getScene();
		
		DoitEtre.nonNul(scene);

		fenetrePrincipale.setScene(scene);
		fenetrePrincipale.show();

	}
	
	@Override
	public void stop() {
		J.appel(this);
	}
}

