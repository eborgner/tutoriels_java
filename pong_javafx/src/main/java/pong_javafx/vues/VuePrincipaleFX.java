package pong_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import pong_client.vues.VuePrincipale;
import static pong_javafx.Constantes.*;

public class VuePrincipaleFX implements VuePrincipale, Initializable {
	
	@FXML
	private Pane conteneurPartie;
	
	

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
	}
	
	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeurVuePartieLocale = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML, 
																									    CHEMIN_CHAINES, 
																									    CHEMIN_PARTIE_LOCALE_CSS);
		VuePartieLocaleFX vuePartieLocaleFX = chargeurVuePartieLocale.getVue();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(chargeurVuePartieLocale.getParent());

		return vuePartieLocaleFX;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

}
