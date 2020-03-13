package tp01_corrige_javafx.vues.composants;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import tp01_corrige.enumerations.Couleur;

public class ConteneurGrille extends VBox {
    
    private Color couleurRouge;
    private Color couleurJaune;
    
    private Timeline animationViderGrille;
    
    public ConteneurGrille(@NamedArg("couleurRouge") String couleurRouge, @NamedArg("couleurJaune") String couleurJaune) {
        super();
        J.appel(this);

        if(couleurRouge != null && !couleurRouge.isEmpty()) {
            this.couleurRouge = Color.valueOf(couleurRouge);
        }
        
        if(couleurJaune != null && !couleurJaune.isEmpty()) {
            this.couleurJaune = Color.valueOf(couleurJaune);
        }
        
        creerAnimationViderGrille();
    }
    
    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);
        
        this.getStyleClass().add("conteneurGrille");
        
        VBox.setVgrow(this, Priority.ALWAYS);
        
        for(int i = 0; i < hauteur; i++) {

            this.getChildren().add(new ConteneurLigne(largeur, couleurRouge, couleurJaune));
        }
    }

    public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
        J.appel(this);
        
        if(siIndiceRangeeValide(indiceRangee)) {
            
            ConteneurLigne conteneurLigne = getConteneurLigne(indiceRangee);
            conteneurLigne.afficherJeton(indiceColonne, couleur);
        }
    }
    
    private boolean siIndiceRangeeValide(int indiceRangee) {
        J.appel(this);

        return indiceRangee >= 0 && indiceRangee < this.getChildren().size();
    }

    private ConteneurLigne getConteneurLigne(int indiceRangee) {
        J.appel(this);

        return (ConteneurLigne) this.getChildren().get(indiceRangee);
    }



    private void creerAnimationViderGrille() {
        J.appel(this);
        
        animationViderGrille = new Timeline();
        
        animationViderGrille.getKeyFrames().add(new KeyFrame(Duration.ZERO,
                                                             new KeyValue(this.rotateProperty(), 0)));
        
        double rotation = 5;
        
        int i;
        
        for(i = 0 ; i < 7; i++) {
            
            rotation = -1*rotation;

            animationViderGrille.getKeyFrames().add(
                    new KeyFrame(new Duration(i*50l),
                            new KeyValue(this.rotateProperty(), rotation)));
            
        }

        animationViderGrille.getKeyFrames().add(
                new KeyFrame(new Duration(i*50l),
                        new KeyValue(this.rotateProperty(), 0)));
    }

}
