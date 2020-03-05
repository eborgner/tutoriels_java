package tp01_temps_reel_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;

import static tp01_temps_reel_javafx.Constantes.*;

import java.util.Locale;

import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp01_temps_reel_javafx.controleurs.ControleurAccueilFX;
import tp01_temps_reel_javafx.vues.VueAccueilFX;

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

		ChargeurDeVue<VueAccueilFX> chargeur = creerChargeurAccueil();

		installerSceneAccueil(fenetrePrincipale, chargeur);

		instancierMVCAccueil(chargeur);
		
		fenetrePrincipale.show();
	}


	private void instancierMVCAccueil(ChargeurDeVue<VueAccueilFX> chargeur) {
		J.appel(this);

		VueAccueilFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueilFX.class, 
	   									   vue);
	}

	private ChargeurDeVue<VueAccueilFX> creerChargeurAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueilFX> chargeur = new ChargeurDeVue<VueAccueilFX>(CHEMIN_ACCUEIL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_ACCUEIL_CSS);

		return chargeur;
	}

	private void installerSceneAccueil(Stage fenetrePrincipale, 
			                           ChargeurDeVue<VueAccueilFX> chargeur) {
		J.appel(this);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);
		
		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setWidth(Constantes.LARGEUR);
		fenetrePrincipale.setHeight(Constantes.HAUTEUR);
	}
}

