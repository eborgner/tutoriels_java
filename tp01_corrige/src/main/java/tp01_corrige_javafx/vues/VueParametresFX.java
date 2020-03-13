package tp01_corrige_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.fxml.Initializable;
import tp01_corrige.enumerations.Choix;
import tp01_corrige_client.commandes.fermer_parametres.FermerParametres;
import tp01_corrige_client.commandes.fermer_parametres.FermerParametresPourEnvoi;
import tp01_corrige_client.vues.VueParametres;

public class VueParametresFX implements VueParametres, Initializable {
	
	private FermerParametresPourEnvoi fermerParametres;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	@Override
	public void afficherChoix(Choix choix) {
		J.appel(this);
		
		
	}


}
