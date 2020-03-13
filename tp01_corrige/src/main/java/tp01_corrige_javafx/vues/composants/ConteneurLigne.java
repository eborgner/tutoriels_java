package tp01_corrige_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import tp01_corrige.enumerations.Couleur;

public class ConteneurLigne extends HBox {
    
    public ConteneurLigne(int largeur, Color couleurRouge, Color couleurJaune) {
        J.appel(this);
        
        this.getStyleClass().add("conteneurLigne");
        
        VBox.setVgrow(this, Priority.ALWAYS);
        
        for(int i = 0; i < largeur; i++) {
            
            CaseAjustable caseAjustable = new CaseAjustable(couleurRouge, couleurJaune);
            
            caseAjustable.getStyleClass().add("conteneurCase");
            
            HBox.setHgrow(caseAjustable, Priority.ALWAYS);
            
            this.getChildren().add(caseAjustable);
        }
    }

    public void afficherJeton(int indiceColonne, Couleur couleur) {
        J.appel(this);
        
        if(siIndiceColonneValide(indiceColonne)) {

            CaseAjustable caseAjustable = getCase(indiceColonne);
            caseAjustable.afficherJeton(couleur);
        }
    }

    private CaseAjustable getCase(int indiceColonne) {
        J.appel(this);

        return (CaseAjustable) this.getChildren().get(indiceColonne);
    }

    private boolean siIndiceColonneValide(int indiceColonne) {
        J.appel(this);

        return indiceColonne < this.getChildren().size();
    }
}
