package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import javafx.scene.layout.VBox;
import quatredesuite.modeles.sauvegardes.UneSauvegardeLectureSeule;

public class ConteneurSauvegardes extends VBox {
	
	
	public void ajouterItem(UneSauvegardeLectureSeule uneSauvegardeLectureSeule) {
		J.appel(this);
		
		AfficheurUneSauvegarde afficheur = new AfficheurUneSauvegarde(uneSauvegardeLectureSeule, styleClassLigne());

		this.getChildren().add(afficheur);
	}
	
	private String styleClassLigne() {
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
