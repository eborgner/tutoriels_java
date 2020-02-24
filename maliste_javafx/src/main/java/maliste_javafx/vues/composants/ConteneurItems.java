package maliste_javafx.vues.composants;


import commun.debogage.J;
import javafx.scene.layout.VBox;
import maliste.modeles.liste.ItemLectureSeule;

public class ConteneurItems extends VBox {
	
	public void ajouterItem(ItemLectureSeule itemLectureSeule) {
		J.appel(this);
		
		Item item = new Item(itemLectureSeule);

		this.getChildren().add(item);
	}

	public void vider() {
		J.appel(this);
		
		this.getChildren().clear();
	}
}
