package maliste_javafx.vues.composants;


import commun.debogage.J;
import javafx.scene.layout.VBox;
import maliste.modeles.liste.ItemLectureSeule;

public class ConteneurItems extends VBox {
	
	
	public void ajouterItem(ItemLectureSeule itemLectureSeule) {
		J.appel(this);
		
		ItemGraphique item = new ItemGraphique(itemLectureSeule, styleClassItem());

		this.getChildren().add(item);
	}
	
	private String styleClassItem() {
		J.appel(this);

		boolean siPair = this.getChildren().size()%2 == 0;
		
		String styleClassItem = "rangeeImpaire";
		
		if(siPair) {
			styleClassItem = "rangeePaire";
		}
		
		return styleClassItem;
	}

	public void vider() {
		J.appel(this);
		
		this.getChildren().clear();
	}
}
