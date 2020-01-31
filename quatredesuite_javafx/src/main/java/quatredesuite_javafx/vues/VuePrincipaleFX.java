package quatredesuite_javafx.vues;


import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.ChargeurDeVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuItem;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocalePourEnvoi;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import quatredesuite_client.commandes.quitter.Quitter;
import quatredesuite_client.commandes.quitter.QuitterPourEnvoi;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_client.vues.VuePrincipale;
import static quatredesuite_javafx.Constantes.*;

public class VuePrincipaleFX implements VuePrincipale {
	
	@FXML
	private MenuItem nouvellePartie, parametres, quitter;

	@FXML
	private VBox conteneurPartieLocale;
	
	private NouvellePartieLocalePourEnvoi nouvellePartieLocale;
	private OuvrirParametresPourEnvoi ouvrirParametres;
	private QuitterPourEnvoi commandeQuitter;

	@Override
	public void creerEvenements() {
		J.appel(this);
		
		nouvellePartieLocale = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		ouvrirParametres = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		commandeQuitter = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerListeners() {
		J.appel(this);
		
		installerListenerNouvellePartie();
		installerListenerParametres();
		installerListenerQuitter();
	}

	private void installerListenerQuitter() {
		J.appel(this);
		
		quitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				commandeQuitter.envoyerCommande();
			}
		});
	}

	private void installerListenerParametres() {
		J.appel(this);
		
		parametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirParametres.envoyerCommande();
			}
		});
	}

	private void installerListenerNouvellePartie() {
		J.appel(this);
		
		nouvellePartie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				nouvellePartieLocale.envoyerCommande();
			}
		});
	}

	@Override
	public VuePartieLocale creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_PRINCIPAL_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		Parent racinePartieLocale = chargeur.getParent();
		
		conteneurPartieLocale.getChildren().add(racinePartieLocale);
		conteneurPartieLocale.setVisible(true);
		
		return chargeur.getVue();
	}

	@Override
	public void detruireVuePartieLocale() {
		J.appel(this);

		conteneurPartieLocale.getChildren().clear();
	}
}
