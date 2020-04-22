package tp01_temps_reel_javafx.vues;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import tp01_temps_reel.modeles.monde2d.Dessin2D;
import tp01_temps_reel_client.commandes.jouer_coup.JouerCoup;
import tp01_temps_reel_client.commandes.jouer_coup.JouerCoupPourEnvoi;
import tp01_temps_reel_client.vues.VuePartieLocale;
import tp01_temps_reel_javafx.vues.composants.MonDessin2D;
import javafx.fxml.Initializable;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {
	
	@FXML
	private Text texteTmpPartieLocale, texteNombreCoups;
	
	@FXML
	private Button boutonJouerCoup;
	
	@FXML
	private MonDessin2D dessin2D;
	
	private JouerCoupPourEnvoi jouerCoup;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(texteTmpPartieLocale);
		DoitEtre.nonNul(texteNombreCoups);
		DoitEtre.nonNul(boutonJouerCoup);
		DoitEtre.nonNul(dessin2D);
		
		// Nouvelle vue?
		texteTmpPartieLocale.setText(texteTmpPartieLocale.getText() + " (" + System.identityHashCode(this) + ")");
	} 
	
	
	@Override
	public Dessin2D getDessin2D(){
		J.appel(this);
		
		return (Dessin2D) dessin2D;
	}


	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		jouerCoup = FabriqueCommande.obtenirCommandePourEnvoi(JouerCoup.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		boutonJouerCoup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				jouerCoup.setInfoCoup(extraireInfoCoup());
				
				jouerCoup.envoyerCommande();
			}
		});
	}

	private int extraireInfoCoup() {
		J.appel(this);

		return 15 + (new Random()).nextInt(45);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	@Override
	public void afficherNombreCoups(int nombreCoups) {
		J.appel(this);
		
		texteNombreCoups.setText(String.valueOf(nombreCoups));
	}

}