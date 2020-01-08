package commun_javafx;


import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ChargeurDeVueFX {
	
	private String cheminFxml;
	private String cheminChaines;
	private int largeur, hauteur;
	private String[] cheminsCss;
	private FXMLLoader loader;
	private Parent parent;
	private Scene scene;

	public ChargeurDeVueFX(String cheminFxml, String cheminChaines, String... cheminsCss) {

		J.appel(this);
		
		this.cheminFxml = cheminFxml;
		this.cheminChaines = cheminChaines;
		this.cheminsCss = cheminsCss;
		
		creerLoader();
		chargerParent();
		ajouterCss();
	}
	
	public ChargeurDeVueFX(String cheminFxml, 
			String cheminChaines,
			int largeur,
			int hauteur,
			String... cheminsCss) {

		J.appel(this);
		
		this.cheminFxml = cheminFxml;
		this.cheminChaines = cheminChaines;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.cheminsCss = cheminsCss;
		
		creerLoader();
		chargerParent();
		ajouterCss();
		chargerScene();
	}
	
	public Scene getScene() {
		J.appel(this);

		return scene;
	}


	private void creerLoader() {
		J.appel(this);
		
		URL fichierFxml = getFichierFxml();
		
		ResourceBundle chaines = getResourceBundle();

		DoitEtre.nonNul(fichierFxml);
		DoitEtre.nonNul(chaines);
		
		loader = new FXMLLoader(fichierFxml, chaines);
		
		DoitEtre.nonNul(loader);

	}

	private ResourceBundle getResourceBundle() {
		J.appel(this);

		ResourceBundle chaines = null;

		try {

			chaines = ResourceBundle.getBundle(cheminChaines);

		}catch(MissingResourceException e) {
			
			Erreur.fatale("cheminChaines non-trouvé '" + cheminChaines + "'", e);
			
		}

		return chaines;
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
	
	private void ajouterCss() {
		J.appel(this);
		DoitEtre.nonNul(cheminsCss);

		for(String cheminCss : cheminsCss) {

			URL fichierCss = ChargeurDeVueFX.class.getResource(cheminCss);
			parent.getStylesheets().add(fichierCss.toExternalForm());

		}
	}

	public Parent getParent() {
		J.appel(this);
		DoitEtre.nonNul(parent);

		return parent;
	}
}
