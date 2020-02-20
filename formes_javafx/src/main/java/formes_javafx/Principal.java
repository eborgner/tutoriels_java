package formes_javafx;

import java.io.InputStream;

import commun.debogage.J;
import commun_javafx.Initialisateur;
import formes.EntrepotFormes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal extends Application {
	
	static{
	
		Initialisateur.initialiser();

	}
    
    private static final String CHEMIN_FICHIER_ENTREE = "/entrees/01.txt";

    private static final int HAUTEUR = 400;
    private static final int LARGEUR = 600;

    private static DessinFX dessin;

    public static void main(String[] args) {
    	J.appel(Principal.class);

        launch(args);
    }
    
    @Override
    public void start(Stage fenetrePrincipale) throws Exception {
    	J.appel(Principal.class);
        
        Scene scene = creerScene();
        
        chargerFormes();
        afficherFormes();

        fenetrePrincipale.setScene(scene);
        fenetrePrincipale.show();
    }

    private Scene creerScene() {
    	J.appel(Principal.class);

    	dessin = new DessinFX(LARGEUR, HAUTEUR);
        
        Pane pane = new Pane();
        pane.getChildren().add(dessin);

        Scene scene = new Scene(pane, LARGEUR, HAUTEUR);

        return scene;
    }

    private void chargerFormes() {
    	J.appel(Principal.class);

        InputStream streamFormes = Principal.class.getResourceAsStream(CHEMIN_FICHIER_ENTREE);
        
        EntrepotFormes.chargerFormes(streamFormes);
    }
    
    private void afficherFormes() {
    	J.appel(Principal.class);
    	
    	EntrepotFormes.afficherformes(dessin);
    }

}
