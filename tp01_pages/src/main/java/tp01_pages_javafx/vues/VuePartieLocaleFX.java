package tp01_pages_javafx.vues;

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
import tp01_pages_client.commandes.jouer_coup.JouerCoup;
import tp01_pages_client.commandes.jouer_coup.JouerCoupPourEnvoi;
import tp01_pages_client.commandes.retour_accueil.RetourAccueil;
import tp01_pages_client.commandes.retour_accueil.RetourAccueilPourEnvoi;
import tp01_pages_client.vues.VuePartieLocale;
import javafx.fxml.Initializable;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {
	
	@FXML
	private Text texteTmpPartieLocale, texteNombreCoups;
	
	@FXML
	private Button boutonJouerCoup, boutonRetour;
	
	private JouerCoupPourEnvoi jouerCoup;

	private RetourAccueilPourEnvoi retourAccueil;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(texteTmpPartieLocale);
		DoitEtre.nonNul(texteNombreCoups);
		DoitEtre.nonNul(boutonJouerCoup);
		DoitEtre.nonNul(boutonRetour);
		
		// Nouvelle vue?
		texteTmpPartieLocale.setText(texteTmpPartieLocale.getText() + " (" + System.identityHashCode(this) + ")");
	} 

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		jouerCoup = FabriqueCommande.obtenirCommandePourEnvoi(JouerCoup.class);

		retourAccueil = FabriqueCommande.obtenirCommandePourEnvoi(RetourAccueil.class);
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

		boutonRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				retourAccueil.envoyerCommande();
			}
		});
	}

	private int extraireInfoCoup() {
		J.appel(this);

		return (new Random()).nextInt(3);
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
