package tp01_menu_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import tp01_menu_client.vues.VuePartieLocale;
import javafx.fxml.Initializable;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {
	
	@FXML
	private Text texteTmpPartieLocale;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		// Nouvelle vue?
		texteTmpPartieLocale.setText(texteTmpPartieLocale.getText() + " (" + System.identityHashCode(this) + ")");
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
}
