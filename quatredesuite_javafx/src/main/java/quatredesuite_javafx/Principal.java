package quatredesuite_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import static commun_javafx.Constantes.*;
import static quatredesuite_javafx.Constantes.*;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
	
	static {
		J.appel(Principal.class);

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

		fenetrePrincipale.show();

	}

	private Scene creerScenePrincipale() {
		J.appel(this);

		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PRINCIPAL_FXML,
				CHEMIN_PRINCIPAL_CHAINES,
				CHEMIN_PRINCIPAL_CSS);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);

		DoitEtre.nonNul(scene);
		return scene;
	}
	
	@Override
	public void stop() {
		J.appel(this);
	}
}

