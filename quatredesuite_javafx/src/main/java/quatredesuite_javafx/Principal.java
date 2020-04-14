package quatredesuite_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;

import static quatredesuite_javafx.Constantes.*;

import java.net.URI;
import java.net.URISyntaxException;

import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quatredesuite_javafx.controleurs.ControleurAccueilFX;
import quatredesuite_javafx.vues.VueAccueilFX;

public class Principal extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(Principal.class);
	}
	
	private static ClientQuatreDeSuite client;
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		connecterAuServeur();
		
		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);

		ChargeurDeVue<VueAccueilFX> chargeur = new ChargeurDeVue<VueAccueilFX>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PRINCIPAL_CSS);

		VueAccueilFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueilFX.class, 
										   vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		/*
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.setMaxWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMaxHeight(HAUTEUR_PIXELS);
		*/

		fenetrePrincipale.show();
	}
	
	private void connecterAuServeur() {
		J.appel(this);

		URI uriServeur = null;
		String adresseServeur = quatredesuite.Constantes.ADRESSE_SERVEUR;
		
		try {

			uriServeur = new URI(adresseServeur);

		} catch (URISyntaxException e) {
			
			Erreur.fatale("L'adresse du serveur est mal formée: " + adresseServeur, e);
		}

		connecterAuServeur(uriServeur);
	}

	private void connecterAuServeur(URI uriServeur) {
		J.appel(this);

		client = new ClientQuatreDeSuite(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			client.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
	
	public static boolean siConnecteAuServeur() {
		J.appel(Principal.class);
		
		return client != null && client.isOpen();
	}
}
