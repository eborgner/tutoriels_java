package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import quatredesuite.enumerations.Couleur;

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
		
		if(indiceColonne < this.getChildren().size()) {

			CaseAjustable caseAjustable = (CaseAjustable) this.getChildren().get(indiceColonne);
			caseAjustable.afficherJeton(couleur);
		}
	}

	public void animerSortieJetons() {
		J.appel(this);
		
		for(int indiceColonne = 0; indiceColonne < this.getChildren().size(); indiceColonne++) {
			
			CaseAjustable caseAjustable = (CaseAjustable) this.getChildren().get(indiceColonne);
			
			caseAjustable.animerSortieJeton();
		}
	}

	public void animerEntreeJeton(int indiceColonne) {
		J.appel(this);

		if(indiceColonne < this.getChildren().size()) {

			CaseAjustable caseAjustable = (CaseAjustable) this.getChildren().get(indiceColonne);
			caseAjustable.animerEntreeJeton();
		}
	}
}
