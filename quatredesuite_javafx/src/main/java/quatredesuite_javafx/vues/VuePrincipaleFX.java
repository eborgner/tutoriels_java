package quatredesuite_javafx.vues;


import commun.debogage.J;
import commun_client.evenements.FabriqueEvenement;
import commun_client.structure.Vue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import quatredesuite_client.evenements.nouvelle_partie_locale.NouvellePartieLocaleLance;

public class VuePrincipaleFX implements Vue {
	
	@FXML
	MenuItem nouvellePartie;
	
	NouvellePartieLocaleLance nouvellePartieLocale;

	@Override
	public void creerEvenements() {
		J.appel(this);
		
		nouvellePartieLocale = FabriqueEvenement.creerEvenement(NouvellePartieLocaleLance.class);
	}

	@Override
	public void installerListeners() {
		J.appel(this);
		
		nouvellePartie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				nouvellePartieLocale.lancer();
			}
		});
	}
}
