package tp01_pages_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.paint.Color;

public class MonRadio extends CaseAjustable {
		
	public void selectionner(boolean siSelectionne) {
		J.appel(this);
		
		if(siSelectionne) {

			pinceau.setFill(Color.BLUE);

		}else {

			pinceau.setFill(Color.WHITE);

		}
		
		viderDessin();
		dessinerCase();
	}
}
