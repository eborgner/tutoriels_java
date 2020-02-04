package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.beans.NamedArg;
import javafx.scene.layout.HBox;

public class ConteneurEntetes extends HBox {
	
	private String texteBouton;

	public ConteneurEntetes(@NamedArg("texteBouton") String texteBouton) {
		J.appel(this);
		
		this.texteBouton = texteBouton;
	}
}
