package maliste_javafx.vues.composants;

import commandes.retirer_item.RetirerItem;
import commandes.retirer_item.RetirerItemPourEnvoi;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import maliste.modeles.liste.ItemLectureSeule;

public class Item extends HBox {
	
	public Item(ItemLectureSeule itemLectureSeule) {
		super();
		J.appel(this);
		
		this.getChildren().add(new Text(itemLectureSeule.getTexte()));
		
		HBox espaceGauche = new HBox();
		espaceGauche.getStyleClass().add("petitEspace");

		this.getChildren().add(espaceGauche);
		
		CheckBox boutonEffacer = new CheckBox();

		HBox espaceDroite = new HBox();
		espaceDroite.getStyleClass().add("petitEspace");

		this.getChildren().add(espaceDroite);

		this.getChildren().add(boutonEffacer);
		
		RetirerItemPourEnvoi retirerItemPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(RetirerItem.class);
		
		boutonEffacer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				retirerItemPourEnvoi.setId(itemLectureSeule.getId());
				retirerItemPourEnvoi.envoyerCommande();
			}
		});
	}

}
