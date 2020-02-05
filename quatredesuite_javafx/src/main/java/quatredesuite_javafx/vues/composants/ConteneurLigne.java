package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import quatredesuite.enumerations.Couleur;

public class ConteneurLigne extends HBox {
	
	public ConteneurLigne(int largeur) {
		J.appel(this);
		
		this.getStyleClass().add("conteneurLigne");
		
		VBox.setVgrow(this, Priority.ALWAYS);
		
		for(int i = 0; i < largeur; i++) {
			
			CaseAjustable caseAjustable = new CaseAjustable();
			
			caseAjustable.getStyleClass().add("conteneurCase");
			
			HBox.setHgrow(caseAjustable, Priority.ALWAYS);
			
			this.getChildren().add(caseAjustable);
		}
	}

	public void afficherJeton(int indiceColonne, Couleur couleur) {
		J.appel(this);
		
		CaseAjustable caseAjustable = (CaseAjustable) this.getChildren().get(indiceColonne);
		caseAjustable.afficherJeton(couleur);
	}
}
