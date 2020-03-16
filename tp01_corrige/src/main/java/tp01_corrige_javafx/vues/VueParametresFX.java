package tp01_corrige_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import tp01_corrige.enumerations.TailleGrille;
import tp01_corrige_client.commandes.choisir_taille.ChoisirTaille;
import tp01_corrige_client.commandes.choisir_taille.ChoisirTaillePourEnvoi;
import tp01_corrige_client.commandes.fermer_parametres.FermerParametres;
import tp01_corrige_client.commandes.fermer_parametres.FermerParametresPourEnvoi;
import tp01_corrige_client.vues.VueParametres;

public class VueParametresFX implements VueParametres, Initializable {
	
	private FermerParametresPourEnvoi fermerParametres;
	private ChoisirTaillePourEnvoi choisirTaille;
	
	@FXML
	private CheckBox checkPetite, checkMoyenne, checkGrande;
	
	@FXML
	private Button boutonOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(checkPetite);
		DoitEtre.nonNul(checkMoyenne);
		DoitEtre.nonNul(checkGrande);
		DoitEtre.nonNul(boutonOk);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
		choisirTaille = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTaille.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		checkPetite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				choisirTaille.setTaille(TailleGrille.PETITE);
				choisirTaille.envoyerCommande();
			}
		});
		
		checkMoyenne.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirTaille.setTaille(TailleGrille.MOYENNE);
				choisirTaille.envoyerCommande();
			}
		});

		checkGrande.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirTaille.setTaille(TailleGrille.GRANDE);
				choisirTaille.envoyerCommande();
			}
		});
		
		boutonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				fermerParametres.envoyerCommande();
			}
		});
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	@Override
	public void afficherTaille(TailleGrille taille) {
		J.appel(this);
		
		switch(taille) {
		
		case PETITE:
			checkPetite.setSelected(true);
			checkMoyenne.setSelected(false);
			checkGrande.setSelected(false);
			break;

		case MOYENNE:
			checkPetite.setSelected(false);
			checkMoyenne.setSelected(true);
			checkGrande.setSelected(false);
			break;
			
		case GRANDE:
			checkPetite.setSelected(false);
			checkMoyenne.setSelected(false);
			checkGrande.setSelected(true);
			break;
		
		}
	}
}
