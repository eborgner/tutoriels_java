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

	public void creerEntetes(int largeur) {
		J.appel(this);
		
		for(int i = 0; i < largeur; i++) {
			
			this.getChildren().add(new Entete(texteBouton));
		}
	}

}
