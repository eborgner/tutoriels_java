package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConteneurGrille extends VBox {

	public void creerGrille(int largeur, int hauteur) {
		J.appel(this);
		
		this.getStyleClass().add("conteneurGrille");
		
		VBox.setVgrow(this, Priority.ALWAYS);
		
		for(int i = 0; i < hauteur; i++) {

			this.getChildren().add(new ConteneurLigne(largeur));
		}
	}
}
