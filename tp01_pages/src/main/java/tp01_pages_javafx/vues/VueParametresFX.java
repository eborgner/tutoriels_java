package tp01_pages_javafx.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import tp01_pages.enumerations.Choix;
import tp01_pages_client.commandes.changer_locale.ChangerLocale;
import tp01_pages_client.commandes.changer_locale.ChangerLocalePourEnvoi;
import tp01_pages_client.commandes.choisir_choix.ChoisirChoix;
import tp01_pages_client.commandes.choisir_choix.ChoisirChoixPourEnvoi;
import tp01_pages_client.commandes.retour_accueil.RetourAccueil;
import tp01_pages_client.commandes.retour_accueil.RetourAccueilPourEnvoi;
import tp01_pages_client.vues.VueParametres;
import tp01_pages_javafx.vues.composants.CaseAjustable;
import tp01_pages_javafx.vues.composants.MonRadio;

public class VueParametresFX implements VueParametres, Initializable {
	
	@FXML
	private Text texteTmpParametres;
	
	@FXML
	private MonRadio radioUn, radioDeux, radioTrois;
	
	@FXML
	private Button boutonChangerLangue, boutonRetour;

	private ChoisirChoixPourEnvoi choisirChoix;
	private ChangerLocalePourEnvoi changerLocale;
	private RetourAccueilPourEnvoi retourAccueil;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(texteTmpParametres);
		DoitEtre.nonNul(radioUn);
		DoitEtre.nonNul(radioDeux);
		DoitEtre.nonNul(radioTrois);
		DoitEtre.nonNul(boutonChangerLangue);
		DoitEtre.nonNul(boutonRetour);

		// Nouvelle vue?
		texteTmpParametres.setText(texteTmpParametres.getText() + " (" + System.identityHashCode(this) + ")");
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		choisirChoix = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirChoix.class);
		
		changerLocale = FabriqueCommande.obtenirCommandePourEnvoi(ChangerLocale.class);
		
		retourAccueil = FabriqueCommande.obtenirCommandePourEnvoi(RetourAccueil.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		radioUn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				
				choisirChoix.setChoix(Choix.UN);
				choisirChoix.envoyerCommande();
			}
		});
		
		radioDeux.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				choisirChoix.setChoix(Choix.DEUX);
				choisirChoix.envoyerCommande();
			}
		});
		
		radioTrois.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				choisirChoix.setChoix(Choix.TROIS);
				choisirChoix.envoyerCommande();
			}
		});
		
		boutonRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				retourAccueil.envoyerCommande();
			}
		});
		
		boutonChangerLangue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				changerLocale.setLocale(choisirProchaineLangue());
				changerLocale.envoyerCommande();
			}
		});
	}
	
	private Locale choisirProchaineLangue() {
		J.appel(this);
		
		Locale prochaineLangue = Locale.CANADA_FRENCH;

		if(Locale.getDefault() == Locale.CANADA_FRENCH) {
			
			prochaineLangue = Locale.CANADA;
		}
		
		return prochaineLangue;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	@Override
	public void afficherChoix(Choix choix) {
		J.appel(this);
		
		switch(choix) {
		
		case UN:
			radioUn.selectionner(true);
			radioDeux.selectionner(false);
			radioTrois.selectionner(false);
			break;

		case DEUX:
			radioUn.selectionner(false);
			radioDeux.selectionner(true);
			radioTrois.selectionner(false);
			break;

		case TROIS:
			radioUn.selectionner(false);
			radioDeux.selectionner(false);
			radioTrois.selectionner(true);
			break;
		}
		
	}


}
