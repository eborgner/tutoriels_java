package tp01_une_page_javafx.vues;

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
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import tp01_une_page_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_une_page_client.commandes.nouvelle_partie.NouvellePartiePourEnvoi;
import tp01_une_page_client.commandes.ouvrir_parametres.OuvrirParametres;
import tp01_une_page_client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import tp01_une_page_client.commandes.quitter.Quitter;
import tp01_une_page_client.commandes.quitter.QuitterPourEnvoi;
import tp01_une_page_client.vues.VueAccueil;
import static tp01_une_page_javafx.Constantes.*;

public class VueAccueilFX implements VueAccueil, Initializable {
	
	@FXML
	Button boutonNouvellePartie;
	
	@FXML
	VBox conteneurPartie, conteneurParametres;
	
	NouvellePartiePourEnvoi nouvellePartiePourEnvoi;

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvellePartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartie.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		boutonNouvellePartie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartiePourEnvoi.envoyerCommande();
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
	}

	public VueParametresFX creerVueParametres() {
		J.appel(this);

		ChargeurDeVue<VueParametresFX> chargeur;
		chargeur = new ChargeurDeVue<VueParametresFX>(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		VueParametresFX vueParametresFX = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurParametres.getChildren().clear();
		conteneurParametres.getChildren().add(parent);
		
		return vueParametresFX;
	}

	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}
}
