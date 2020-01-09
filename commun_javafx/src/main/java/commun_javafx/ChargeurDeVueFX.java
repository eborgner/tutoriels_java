package commun_javafx;

import java.net.URL;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ChargeurDeVueFX {
	
	private String cheminFxml;
	private int largeur, hauteur;
	private FXMLLoader loader;
	private Parent parent;
	private Scene scene;

	
	public ChargeurDeVueFX(String cheminFxml, 
			int largeur,
			int hauteur) {

		J.appel(this);
		
		this.cheminFxml = cheminFxml;
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		creerLoader();
		chargerParent();
		chargerScene();
	}
	
	public Scene getScene() {
		J.appel(this);

		return scene;
	}


	private void creerLoader() {
		J.appel(this);
		
		URL fichierFxml = getFichierFxml();
		
		DoitEtre.nonNul(fichierFxml);
		
		loader = new FXMLLoader(fichierFxml, null);

		DoitEtre.nonNul(loader);

	}

	private URL getFichierFxml() {
		J.appel(this);

		URL fichierFxml = ChargeurDeVueFX.class.getResource(cheminFxml);

		DoitEtre.nonNul(fichierFxml, "cheminFxml non-trouvé '" + cheminFxml + "'");

		return fichierFxml;
	}
	
	private void chargerParent() {
		J.appel(this);

		try {

			parent = loader.load();

		} catch (Exception e) {
			
			Erreur.fatale("impossible de charger la scène", e);

		}
	}

	private void chargerScene() {
		J.appel(this);
		
		scene = new Scene(parent, largeur, hauteur);
	}
	
	public Parent getParent() {
		J.appel(this);
		DoitEtre.nonNul(parent);

		return parent;
	}
}