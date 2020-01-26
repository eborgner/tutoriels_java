package quatredesuite_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.evenements.FabriqueEvenement;
import commun_client.mvc.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import static quatredesuite_javafx.Constantes.*;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quatredesuite.modeles.ModelePrincipal;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_client.evenements.jouer_ici.JouerIci;
import quatredesuite_client.evenements.jouer_ici.JouerIciLance;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocale;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocaleLance;
import quatredesuite_client.viderGrille.ViderGrille;
import quatredesuite_client.viderGrille.ViderGrilleLance;
import quatredesuite_javafx.vues.VuePrincipaleFX;


public class Principal extends Application {
	
	static {

		Initialisateur.initialiser();
		
		J.appel(Principal.class);

		// FIXME: ça va où??
		FabriqueEvenement.initialiserEvenementLance(NouvellePartieLocaleLance.class, NouvellePartieLocale.class);
		FabriqueEvenement.initialiserEvenementLance(JouerIciLance.class, JouerIci.class);
		FabriqueEvenement.initialiserEvenementLance(ViderGrilleLance.class, ViderGrille.class);
	}
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		launch(args);
	}

	private ControleurPrincipal controleurPrincipal;
	
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		ChargeurDeVue<VuePrincipaleFX> chargeur = creerChargeurVuePrincipale();
		
		controleurPrincipal = creerControleurPrincipal(chargeur);
		
		Scene scene = creerScenePrincipale(chargeur);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(400);
		fenetrePrincipale.setMinHeight(600);

		fenetrePrincipale.show();

	}

	private Scene creerScenePrincipale(ChargeurDeVue<VuePrincipaleFX> chargeur) {
		J.appel(this);

		
		Scene scene = chargeur.nouvelleScene(50, 50, 2);

		DoitEtre.nonNul(scene);

		return scene;
	}

	private ChargeurDeVue<VuePrincipaleFX> creerChargeurVuePrincipale() {
		J.appel(this);

		ChargeurDeVue<VuePrincipaleFX> chargeur = new ChargeurDeVue<VuePrincipaleFX>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_PRINCIPAL_CHAINES,
						CHEMIN_PRINCIPAL_CSS);
		
		return chargeur;
	}

	private ControleurPrincipal creerControleurPrincipal(ChargeurDeVue<VuePrincipaleFX> chargeur) {


		VuePrincipaleFX vuePrincipale = chargeur.getVue();

		ModelePrincipal modelePrincipal = new ModelePrincipal();

		ControleurPrincipal controleurPrincipal = FabriqueControleur.creerControleur(ControleurPrincipal.class, modelePrincipal, vuePrincipale);

		
		return controleurPrincipal;
	}
	
	@Override
	public void stop() {
		J.appel(this);
		
		controleurPrincipal.detruire();
		
	}
}

