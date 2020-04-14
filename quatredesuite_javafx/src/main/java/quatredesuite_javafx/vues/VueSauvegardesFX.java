package quatredesuite_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import quatredesuite.modeles.sauvegardes.UneSauvegardeLectureSeule;
import quatredesuite_client.vues.VueSauvegardes;
import quatredesuite_javafx.vues.composants.ConteneurSauvegardes;

public class VueSauvegardesFX implements VueSauvegardes, Initializable {
	
	@FXML
	ConteneurSauvegardes conteneurSauvegardes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurSauvegardes);
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

	@Override
	public void viderLesSauvegardes() {
		J.appel(this);
		
		conteneurSauvegardes.viderLesSauvegardes();
	}

	@Override
	public void ajouterSauvegarde(UneSauvegardeLectureSeule uneSauvegarde) {
		J.appel(this);

		conteneurSauvegardes.ajouterSauvegarde(uneSauvegarde);
	}
}
