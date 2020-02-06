package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.beans.NamedArg;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import quatredesuite.enumerations.Couleur;

public class ConteneurGrille extends VBox {
	
	private Color couleurRouge;
	private Color couleurJaune;
	
	public ConteneurGrille(@NamedArg("couleurRouge") String couleurRouge, @NamedArg("couleurJaune") String couleurJaune) {
		super();

		if(couleurRouge != null && !couleurRouge.isEmpty()) {
			this.couleurRouge = Color.valueOf(couleurRouge);
		}
		
		if(couleurJaune != null && !couleurJaune.isEmpty()) {
			this.couleurJaune = Color.valueOf(couleurJaune);
		}
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
		
		int indiceRangeeGraphique = convertirIndiceRangee(indiceRangee);
		
		if(siIndiceRangeeGraphiqueValide(indiceRangeeGraphique)) {
			
			ConteneurLigne conteneurLigne = (ConteneurLigne) this.getChildren().get(indiceRangeeGraphique);
			conteneurLigne.afficherJeton(indiceColonne, couleur);
		}
	}

	private boolean siIndiceRangeeGraphiqueValide(int indiceRangeeGraphique) {
		J.appel(this);

		return indiceRangeeGraphique >= 0 && indiceRangeeGraphique < this.getChildren().size();
	}

	private int convertirIndiceRangee(int indiceRangee) {
		J.appel(this);

		return this.getChildren().size() - indiceRangee - 1;
	}
}