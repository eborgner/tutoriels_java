package tp01_menu_javafx.vues;

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
import tp01_menu.enumerations.Choix;
import tp01_menu_client.commandes.changer_locale.ChangerLocale;
import tp01_menu_client.commandes.changer_locale.ChangerLocalePourEnvoi;
import tp01_menu_client.commandes.choisir_choix.ChoisirChoix;
import tp01_menu_client.commandes.choisir_choix.ChoisirChoixPourEnvoi;
import tp01_menu_client.vues.VueParametres;
import tp01_menu_javafx.vues.composants.CaseAjustable;

public class VueParametresFX implements VueParametres, Initializable {
	
	@FXML
	private Text texteTmpParametres;
	
	@FXML
	private CaseAjustable caseUn, caseDeux, caseTrois;
	
	@FXML
	private Button boutonChangerLangue;
	
	private ChoisirChoixPourEnvoi choisirChoix;
	
	private ChangerLocalePourEnvoi changerLocale;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(texteTmpParametres);
		DoitEtre.nonNul(caseUn);
		DoitEtre.nonNul(caseDeux);
		DoitEtre.nonNul(caseTrois);
		DoitEtre.nonNul(boutonChangerLangue);

		// Nouvelle vue?
		texteTmpParametres.setText(texteTmpParametres.getText() + " (" + System.identityHashCode(this) + ")");
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		choisirChoix = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirChoix.class);
		
		changerLocale = FabriqueCommande.obtenirCommandePourEnvoi(ChangerLocale.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		caseUn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				
				choisirChoix.setChoix(Choix.UN);
				choisirChoix.envoyerCommande();
			}
		});
		
		caseDeux.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				choisirChoix.setChoix(Choix.DEUX);
				choisirChoix.envoyerCommande();
			}
		});
		
		caseTrois.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				choisirChoix.setChoix(Choix.TROIS);
				choisirChoix.envoyerCommande();
			}
		});
		
		boutonChangerLangue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				if(Locale.getDefault() == Locale.CANADA_FRENCH) {
					
					changerLocale.setLocale(Locale.CANADA);
					
				}else {

					changerLocale.setLocale(Locale.CANADA_FRENCH);
					
				}
				
				changerLocale.envoyerCommande();
			}
		});
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
			caseUn.afficherChoix();
			caseDeux.viderCase();
			caseTrois.viderCase();
			break;

		case DEUX:
			caseUn.viderCase();
			caseDeux.afficherChoix();
			caseTrois.viderCase();
			break;

		case TROIS:
			caseUn.viderCase();
			caseDeux.viderCase();
			caseTrois.afficherChoix();
			break;
		}
		
	}


}
