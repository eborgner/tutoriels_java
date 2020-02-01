package pong_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pong.modeles.partie.monde2d.Objet2DLectureSeule;
import pong_client.vues.VuePartieLocale;
import pong_javafx.vues.composants.TablePong;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {
	
	@FXML
	private TablePong tablePong;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(tablePong);
		
		tablePong.initialiser();
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		tablePong.obtenirCommandesPourEnvoi();
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

	}


	@Override
	public void viderMonde() {
		J.appel(this);

		tablePong.viderDessin();
	}

	@Override
	public void afficherObjet2D(Objet2DLectureSeule objet2D) {
		J.appel(this);
		
		tablePong.afficherObjet2D(objet2D);
	}

}
