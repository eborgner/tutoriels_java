package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class Grille extends GridPane {

	protected void ajusterMiseEnPageColonnes(int largeur, ColumnConstraints contraintesColonne) {
		J.appel(this);

        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
            this.getColumnConstraints().add(contraintesColonne);
        }
	}

}
