package tp01_menu_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;

import static tp01_menu_javafx.Constantes.*;

import java.util.Locale;

import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp01_menu_client.commandes.changer_locale.ChangerLocale;
import tp01_menu_client.commandes.changer_locale.ChangerLocaleRecue;
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

	
	private Stage fenetrePrincipale;
	private ControleurAccueilFX controleurAccueil;

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		this.fenetrePrincipale = fenetrePrincipale;
		
		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
		installerRecepteurCommandeChangerLocale();


		fenetrePrincipale.show();
		
		creerControleurAccueil();
	}


	private void creerControleurAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueilFX> chargeur = creerChargeurAccueil();

		installerSceneAccueil(chargeur);
		
		VueAccueilFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		controleurAccueil = FabriqueControleur.creerControleur(ControleurAccueilFX.class, 
																 vue);
	}


	private void installerSceneAccueil(ChargeurDeVue<VueAccueilFX> chargeur) {
		J.appel(this);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);
		
		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setWidth(scene.getWidth());
		fenetrePrincipale.setHeight(scene.getHeight());
	}


	private ChargeurDeVue<VueAccueilFX> creerChargeurAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueilFX> chargeur = new ChargeurDeVue<VueAccueilFX>(CHEMIN_ACCUEIL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_ACCUEIL_CSS);
		return chargeur;
	}
	
	private void installerRecepteurCommandeChangerLocale() {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(ChangerLocale.class, new RecepteurCommande<ChangerLocaleRecue>() {
			@Override
			public void executerCommande(ChangerLocaleRecue commande) {
				J.appel(this);
				
				changerLocaleEtRafraichir(commande.getLocale());
			}
		});
	}

	private void changerLocaleEtRafraichir(Locale locale) {
		J.appel(Principal.class);
		
		Locale.setDefault(locale);
		
		recreerVueAccueil();
	}
	
	private void recreerVueAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueilFX> chargeur = creerChargeurAccueil();

		installerSceneAccueil(chargeur);
		
		VueAccueilFX vue = chargeur.getVue();
		
		FabriqueControleur.recreerVue(controleurAccueil, vue);
		
	}
	
	
}

