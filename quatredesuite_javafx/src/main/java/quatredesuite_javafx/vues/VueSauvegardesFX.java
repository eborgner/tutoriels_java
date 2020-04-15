package quatredesuite_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import quatredesuite.modeles.sauvegardes.UneSauvegardeLectureSeule;
import quatredesuite_client.vues.VueSauvegardes;
import quatredesuite_javafx.Constantes;
import quatredesuite_javafx.vues.composants.ConteneurSauvegardes;

public class VueSauvegardesFX implements VueSauvegardes, Initializable {
	
	@FXML
	Text texteRechercheEnCours, texteRepertoire;
	
	@FXML
	ConteneurSauvegardes conteneurSauvegardes;
	
	private String texteBoutonOuvrir;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(texteRechercheEnCours);
		DoitEtre.nonNul(texteRepertoire);
		DoitEtre.nonNul(conteneurSauvegardes);
		
		texteRepertoire.setWrappingWidth(0.8 * Constantes.LARGEUR_PIXELS);
		
		texteBoutonOuvrir = resources.getString("ouvrirSauvegarde");
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

		conteneurSauvegardes.ajouterSauvegarde(uneSauvegarde, texteBoutonOuvrir);
	}

	@Override
	public void afficherRepertoire(String repertoire) {
		J.appel(this);
		
		texteRepertoire.setText(repertoire);
	}

	@Override
	public void cacherRepertoire() {
		J.appel(this);
		
		texteRepertoire.setVisible(false);
	}

	@Override
	public void cacherRechercheEnCours() {
		J.appel(this);
		
		texteRechercheEnCours.setVisible(false);
	}
}
