package quatredesuite_javafx.vues;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import quatredesuite_client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import quatredesuite_client.commandes.nouvelle_partie_reseau.NouvellePartieReseauPourEnvoi;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import quatredesuite_client.commandes.quitter.Quitter;
import quatredesuite_client.commandes.quitter.QuitterPourEnvoi;
import quatredesuite_client.commandes.sauvegarder_partie.SauvegarderPartie;
import quatredesuite_client.commandes.sauvegarder_partie.SauvegarderPartiePourEnvoi;
import quatredesuite_client.vues.VueAccueil;
import static quatredesuite_javafx.Constantes.*;

public class VueAccueilFX implements VueAccueil, Initializable {
	
	@FXML
	MenuItem menuNouvellePartieLocale, 
	         menuNouvellePartieReseau, 
	         menuSauvegarderPartieLocale, 
	         menuParametres, 
	         menuQuitter;
	
	@FXML
	VBox conteneurPartie;
	
	NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	NouvellePartieReseauPourEnvoi nouvellePartieReseauPourEnvoi;
	SauvegarderPartiePourEnvoi sauvegarderPartiePourEnvoi;
	OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	QuitterPourEnvoi quitterPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuNouvellePartieReseau);
		DoitEtre.nonNul(menuSauvegarderPartieLocale);
		DoitEtre.nonNul(menuParametres);
		DoitEtre.nonNul(menuQuitter);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvellePartieLocalePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		nouvellePartieReseauPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieReseau.class);
		sauvegarderPartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(SauvegarderPartie.class);
		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		menuNouvellePartieLocale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartieLocalePourEnvoi.envoyerCommande();
			}
		});

		menuNouvellePartieReseau.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartieReseauPourEnvoi.envoyerCommande();
			}
		});

		menuParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirParametresPourEnvoi.envoyerCommande();
			}
		});
		
		menuSauvegarderPartieLocale.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				File fichierChoisi = DialogueModal.ouvrirDialogueFichiers();

				if(fichierChoisi != null) {

					String cheminDansHome = Systeme.cheminDansHome(fichierChoisi);

					sauvegarderPartiePourEnvoi.setCheminDansHome(cheminDansHome);
					sauvegarderPartiePourEnvoi.envoyerCommande();
				}
			}
		});
		
		menuQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				quitterPourEnvoi.envoyerCommande();
			}
		});
	}

	public VueSauvegardesFX creerVueSauvegardes() {
		J.appel(this);

		ChargeurDeVue<VueSauvegardesFX> chargeur = new ChargeurDeVue<VueSauvegardesFX>(CHEMIN_VUE_SAUVEGARDES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_VUE_SAUVEGARDES_CSS);
		
		VueSauvegardesFX vueSauvegardes = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vueSauvegardes;

	}

	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	public VuePartieReseauFX creerVuePartieReseau() {
		J.appel(this);

		ChargeurDeVue<VuePartieReseauFX> chargeur = new ChargeurDeVue<VuePartieReseauFX>(CHEMIN_PARTIE_RESEAU_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_RESEAU_CSS);
		
		VuePartieReseauFX vuePartieReseau = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieReseau;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

	}
}
