package quatredesuite_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.ChargeurDeVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartie;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartiePourEnvoi;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import quatredesuite_client.commandes.quitter.Quitter;
import quatredesuite_client.commandes.quitter.QuitterPourEnvoi;
import quatredesuite_client.vues.VuePrincipale;
import static quatredesuite_javafx.Constantes.*;

public class VuePrincipaleFX implements VuePrincipale, Initializable {
	
	@FXML
	MenuItem menuNouvellePartie, menuParametres, menuQuitter;
	
	@FXML
	VBox conteneurPartie;
	
	NouvellePartiePourEnvoi nouvellePartiePourEnvoi;
	OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	QuitterPourEnvoi quitterPourEnvoi;

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvellePartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartie.class);
		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		menuNouvellePartie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
			}
		});

		menuParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
			}
		});
		
		menuQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
	}

	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = null;
		
		
		
		return vuePartieLocale;
	}

}
