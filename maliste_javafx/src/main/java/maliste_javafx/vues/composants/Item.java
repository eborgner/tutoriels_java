package maliste_javafx.vues.composants;

import commun.debogage.J;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Item extends HBox {
	
	public Item(String texte) {
		super();
		J.appel(this);
		
		this.getChildren().add(new Text(texte));
		
		HBox espaceGauche = new HBox();
		espaceGauche.getStyleClass().add("petitEspace");

		this.getChildren().add(espaceGauche);
		
		CheckBox boutonEffacer = new CheckBox();

		HBox espaceDroite = new HBox();
		espaceDroite.getStyleClass().add("petitEspace");

		this.getChildren().add(espaceDroite);

		this.getChildren().add(boutonEffacer);

	}

}
