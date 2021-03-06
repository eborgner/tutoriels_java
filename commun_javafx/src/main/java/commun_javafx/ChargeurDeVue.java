package commun_javafx;

import java.io.IOException;
import java.net.URL;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ChargeurDeVue {
	
	private String cheminFxml;
	private FXMLLoader loader;
	private Parent parent;
	
	public ChargeurDeVue(String cheminFxml) {
		J.appel(this);
		
		DoitEtre.nonNul(cheminFxml);
		
		this.cheminFxml = cheminFxml;
		
		creerLoader();
		chargerParent();
	}
	
	public Scene nouvelleScene(int largeur, int hauteur) {
		J.appel(this);
		
		DoitEtre.nonNul(parent);
		
		return new Scene(parent, largeur, hauteur);
	}


	private void creerLoader() {
		J.appel(this);
		
		URL fichierFxml = getFichierFxml();
		
		loader = new FXMLLoader(fichierFxml, null);
		
		DoitEtre.nonNul(loader);

	}

	private URL getFichierFxml() {
		J.appel(this);

		URL fichierFxml = ChargeurDeVue.class.getResource(cheminFxml);

		DoitEtre.nonNul(fichierFxml, "cheminFxml non-trouvé '" + cheminFxml + "'");

		return fichierFxml;
	}
	
	private void chargerParent() {
		J.appel(this);

		try {

			parent = loader.load();

		} catch (IOException e) {
			
			Erreur.fatale("impossible de charger le parent", e);

		}

		DoitEtre.nonNul(parent);
	}

}