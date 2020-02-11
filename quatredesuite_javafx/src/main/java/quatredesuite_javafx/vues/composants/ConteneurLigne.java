package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConteneurLigne extends HBox {
	
	public ConteneurLigne(int largeur) {
		J.appel(this);
		
		this.getStyleClass().add("conteneurLigne");
		
		VBox.setVgrow(this, Priority.ALWAYS);
		
		for(int i = 0; i < largeur; i++) {
			
			CaseAjustable caseAjustable = new CaseAjustable();
			
			caseAjustable.getStyleClass().add("conteneurCase");
			
			
			this.getChildren().add(caseAjustable);
		}
	}
}
