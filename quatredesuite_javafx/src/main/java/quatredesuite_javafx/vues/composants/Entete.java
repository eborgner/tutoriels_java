package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciPourEnvoi;

public class Entete extends HBox {
    
    private Button bouton;
    private int indiceColonne;
    private JouerIciPourEnvoi jouerIciPourEnvoi;

    public Entete(int indiceColonne, String texteBouton) {
        J.appel(this);

        HBox.setHgrow(this, Priority.ALWAYS);
        this.getStyleClass().add("conteneurBouton");
        
        this.indiceColonne = indiceColonne;

        this.bouton = new Button(texteBouton);
        bouton.getStyleClass().add("boutonCoup");
        this.getChildren().add(bouton);
    }

    public void installerCapteurJouerIci() {
        J.appel(this);
        
        this.bouton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                J.appel(this);
                
                jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
                jouerIciPourEnvoi.envoyerCommande();
            }
        });
    }

    public void verifierCommandePossible(){
        J.appel(this);

    }

    public void setActif(boolean enteteActive) {
        J.appel(this);

    }

    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);
        
        jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
    }
}
