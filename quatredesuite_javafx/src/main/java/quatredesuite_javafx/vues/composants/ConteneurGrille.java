package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import quatredesuite.enumerations.Couleur;

public class ConteneurGrille extends VBox {

	public void creerGrille(int largeur, int hauteur) {
		J.appel(this);
		
		this.getStyleClass().add("conteneurGrille");
		
		VBox.setVgrow(this, Priority.ALWAYS);
		
		for(int i = 0; i < hauteur; i++) {

			this.getChildren().add(new ConteneurLigne(largeur));
		}
	}

	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		int indiceRangeeBasHaut = this.getChildren().size() - indiceRangee - 1;
		
		if(indiceRangeeBasHaut < this.getChildren().size()) {
			
			ConteneurLigne conteneurLigne = (ConteneurLigne) this.getChildren().get(indiceRangeeBasHaut);
			conteneurLigne.afficherJeton(indiceColonne, couleur);
		}
	}
}
