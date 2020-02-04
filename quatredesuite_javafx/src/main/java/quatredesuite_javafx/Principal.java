package quatredesuite_javafx;

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
		
		J.appel(Principal.class);
	}
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR);
		fenetrePrincipale.setMinHeight(HAUTEUR);

		fenetrePrincipale.show();
	}
}

