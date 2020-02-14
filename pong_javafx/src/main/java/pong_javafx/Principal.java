package pong_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.ClientWebSocket;

import static pong_javafx.Constantes.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pong_client.controleurs.ControleurPrincipal;
import pong_javafx.controleurs.ControleurPrincipalFX;
import pong_javafx.vues.VuePrincipaleFX;


@SuppressWarnings("rawtypes")
public class Principal extends Application {
    
	
	private static String titreFenetre = "pong";

    static {

        Initialisateur.initialiser();
        
        J.appel(Principal.class);
    }
    
    public static void main(String[] args) throws URISyntaxException {
        J.appel(Principal.class);
        
        try {
        	
        	titreFenetre = args[0];
        	
        } catch(IndexOutOfBoundsException e) {}
        
        connecterClientWebSocket();
        
        launch(args);
    }

	private static void connecterClientWebSocket() throws URISyntaxException {
		J.appel(Principal.class);

		ClientWebSocket clientWebSocket = new ClientWebSocket(new URI("ws://localhost:" + commun.Constantes.PORT));
        clientWebSocket.connect();
	}

    private ControleurPrincipal controleurPrincipal;
    private static Stage fenetrePrincipale;
    
    @Override
    public void start(Stage fenetrePrincipale) throws Exception {
        J.appel(this);
        
        Principal.fenetrePrincipale = fenetrePrincipale;

        ChargeurDeVue<VuePrincipaleFX> chargeur = creerChargeurVuePrincipale();
        
        controleurPrincipal = creerControleurPrincipal(chargeur);
        
        Scene scene = creerScenePrincipale(chargeur);

        fenetrePrincipale.setScene(scene);
        
        fenetrePrincipale.setMinWidth(LARGEUR);
        fenetrePrincipale.setMinHeight(HAUTEUR);
        
        fenetrePrincipale.setTitle(titreFenetre);

        fenetrePrincipale.show();

    }
    
    public static void ouvrirDialogueModal(Scene scene) {
        J.appel(Principal.class);

        Stage fenetreModale = new Stage();
        fenetreModale.setScene(scene);
        fenetreModale.initOwner(fenetrePrincipale);
        fenetreModale.initModality(Modality.APPLICATION_MODAL);
        fenetreModale.showAndWait();
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
                        CHEMIN_CHAINES,
                        CHEMIN_PRINCIPAL_CSS);
        
        return chargeur;
    }

    private ControleurPrincipal creerControleurPrincipal(ChargeurDeVue<VuePrincipaleFX> chargeur) {


        VuePrincipaleFX vuePrincipale = chargeur.getVue();

        ControleurPrincipalFX controleurPrincipal = FabriqueControleur.creerControleur(ControleurPrincipalFX.class, 
                                                                                       vuePrincipale);

        return controleurPrincipal;
    }
    
    @Override
    public void stop() {
        J.appel(this);
    }
}

