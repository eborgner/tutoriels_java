package pong_javafx.vues;

import commun.debogage.J;
import javafx.fxml.FXML;
import pong_client.vues.VuePartieLocale;
import pong_javafx.vues.composants.TablePong;

public class VuePartieLocaleFX implements VuePartieLocale {
	
	@FXML
	private TablePong tablePong;
	

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
	public void dessinerPalette(double hauteur) {
		J.appel(this);
		
		tablePong.dessinerPalette(hauteur);
		
	}

}
