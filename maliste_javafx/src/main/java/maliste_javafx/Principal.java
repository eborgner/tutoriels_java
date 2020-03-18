package maliste_javafx;

import maliste.modeles.liste.Liste;

import java.net.URI;
import java.net.URISyntaxException;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import maliste_javafx.afficheurs.AfficheurPrincipalFX;
import maliste_javafx.controlleurs.ControleurPrincipalFX;
import maliste_javafx.vues.VuePrincipaleFX;

public class Principal extends Application {

    static {
        J.appel(Principal.class);

        Initialisateur.initialiser();
    }
    
    public static void main(String[] args) {
        J.appel(Principal.class);

        launch(args);
    }
    
    @Override
    public void start(Stage fenetrePrincipale) throws Exception {
        J.appel(this);
        
        connecterWebSocket();
        
        ChargeurDeVue<VuePrincipaleFX> chargeur;
        chargeur = new ChargeurDeVue<VuePrincipaleFX>("/fxml/principal.xml",
                                     "traductions.chaines",
                                      "/css/principal.css");


        Scene scene = chargeur.nouvelleScene(800,600);

        DoitEtre.nonNul(scene);
        
        VuePrincipaleFX vue = chargeur.getVue();
        
        Liste liste = new Liste();
        
        AfficheurPrincipalFX afficheur = new AfficheurPrincipalFX();
        
        FabriqueControleur.creerControleur(ControleurPrincipalFX.class, liste, vue, afficheur);
        

        fenetrePrincipale.setScene(scene);
        fenetrePrincipale.show();
    }

	private void connecterWebSocket() throws URISyntaxException {
		J.appel(this);

		URI uriServeur = new URI("ws://localhost:8765");
        ClientWebSocketMaListe clientWebSocketMaListe = new ClientWebSocketMaListe(uriServeur);
        clientWebSocketMaListe.connect();
	}

    @Override
    public void stop() {
        J.appel(this);
        
        System.exit(0);
    }
}

