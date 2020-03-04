package tp01_menu_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import tp01_menu_client.vues.VueParametres;

public class VueParametresFX implements VueParametres, Initializable {
	
	@FXML
	Text texteTmpParametres;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		// Nouvelle vue?
		texteTmpParametres.setText(texteTmpParametres.getText() + " (" + System.identityHashCode(this) + ")");
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
