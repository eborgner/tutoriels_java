package quatredesuite_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import static quatredesuite_javafx.Constantes.*;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite_client.afficheurs.AfficheurPartieLocale;
import quatredesuite_client.controleurs.ControleurPartieLocale;
import quatredesuite_javafx.vues.VuePartieLocaleFX;

public class Principal extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(Principal.class);
	}
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR);
		fenetrePrincipale.setMinHeight(HAUTEUR);

		fenetrePrincipale.show();

		VuePartieLocaleFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		PartieLocale partie = new PartieLocale();
		
		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();
		
		FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
							               partie,
										   vue,
										   afficheur);
	}
}

