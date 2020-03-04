package tp01_menu_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;

import static tp01_menu_javafx.Constantes.*;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp01_menu_javafx.controleurs.ControleurAccueilFX;
import tp01_menu_javafx.vues.VueAccueilFX;

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
		
		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
		ChargeurDeVue<VueAccueilFX> chargeur = new ChargeurDeVue<VueAccueilFX>(CHEMIN_ACCUEIL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_ACCUEIL_CSS);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR);
		fenetrePrincipale.setMinHeight(HAUTEUR);

		fenetrePrincipale.show();

		VueAccueilFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueilFX.class, 
										   vue);
	}
}

