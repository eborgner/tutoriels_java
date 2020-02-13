package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Entete extends HBox {
	
	private Button bouton;
	private int indiceColonne;

	public Entete(int indiceColonne, String texteBouton) {
		J.appel(this);

		HBox.setHgrow(this, Priority.ALWAYS);
		this.getStyleClass().add("conteneurBouton");

		this.indiceColonne = indiceColonne;

		this.bouton = new Button(texteBouton);
		bouton.getStyleClass().add("boutonCoup");
		this.getChildren().add(bouton);

	}

}
