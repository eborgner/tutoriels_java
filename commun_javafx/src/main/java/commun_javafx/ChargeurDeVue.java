package commun_javafx;

import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ChargeurDeVue {
	
	private String cheminFxml;
    private String cheminChaines;
    private String cheminCss;
	private FXMLLoader loader;
	private Parent parent;
	
	public ChargeurDeVue(String cheminFxml) {
		J.appel(this);
		
		DoitEtre.nonNul(cheminFxml);
		
		this.cheminFxml = cheminFxml;
		
		creerLoader();
		chargerParent();
	}

	public ChargeurDeVue(String cheminFxml,
						 String cheminChaines,
						 String cheminCSS) {
		J.appel(this);
		
		DoitEtre.nonNul(cheminFxml);
		
		this.cheminFxml = cheminFxml;
		this.cheminChaines = cheminChaines;
		this.cheminCss = cheminCSS;
		
		creerLoader();
		chargerParent();
		ajouterCss();
	}
	
	public Scene nouvelleScene(int largeur, int hauteur) {
		J.appel(this);
		
		DoitEtre.nonNul(parent);
		
		return new Scene(parent, largeur, hauteur);
	}


	private void creerLoader() {
		J.appel(this);
		
		URL fichierFxml = getFichierFxml();
		ResourceBundle chaines = null;
		
		if(cheminChaines != null) {
			chaines = getResourceBundle();
			DoitEtre.nonNul(chaines, "Fichier chaînes non-trouvé: " + cheminChaines);
		}
		
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

    private void ajouterCss() {
        J.appel(this);

        DoitEtre.nonNul(parent);
		DoitEtre.nonNul(cheminCss);

		URL fichierCss = ChargeurDeVue.class.getResource(cheminCss);

		DoitEtre.nonNul(fichierCss);

		parent.getStylesheets().add(fichierCss.toExternalForm());
    }

}