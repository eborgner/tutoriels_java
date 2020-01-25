package quatredesuite_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import static quatredesuite_javafx.Constantes.*;
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
		
		Scene scene = creerScenePrincipale();

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(400);
		fenetrePrincipale.setMinHeight(600);

		fenetrePrincipale.show();

	}

	private Scene creerScenePrincipale() {
		J.appel(this);

		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_PRINCIPAL_CHAINES,
						CHEMIN_PRINCIPAL_CSS);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);

		DoitEtre.nonNul(scene);
		return scene;
	}
	
	@Override
	public void stop() {
		J.appel(this);
	}
}

