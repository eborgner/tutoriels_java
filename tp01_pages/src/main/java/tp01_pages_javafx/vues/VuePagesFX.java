package tp01_pages_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import tp01_pages_client.vues.VuePages;

import static tp01_pages_javafx.Constantes.*;

public class VuePagesFX implements VuePages, Initializable {
	
	@FXML
	Pane conteneurAccueil, conteneurPartie, conteneurParametres;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurAccueil);
		DoitEtre.nonNul(conteneurPartie);
		DoitEtre.nonNul(conteneurParametres);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
	}

	@Override
	public void verifierCommandesPossibles() {
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

	public VueAccueilFX creerVueAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueilFX> chargeur;
		chargeur = new ChargeurDeVue<VueAccueilFX>(CHEMIN_ACCUEIL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_ACCUEIL_CSS);
		
		VueAccueilFX vueAcceuil = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurAccueil.getChildren().clear();
		conteneurAccueil.getChildren().add(parent);
		
		return vueAcceuil;
		
	}

	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	public void afficherPageAccueil() {
		J.appel(this);
		
		conteneurAccueil.setVisible(true);
		conteneurParametres.setVisible(false);
		conteneurPartie.setVisible(false);
	}

	public void afficherPageParametres() {
		J.appel(this);

		conteneurAccueil.setVisible(false);
		conteneurParametres.setVisible(true);
		conteneurPartie.setVisible(false);
	}

	public void afficherPagePartieLocale() {
		J.appel(this);

		conteneurAccueil.setVisible(false);
		conteneurParametres.setVisible(false);
		conteneurPartie.setVisible(true);
	}

}
