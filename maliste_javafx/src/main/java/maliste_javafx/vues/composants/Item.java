package maliste_javafx.vues.composants;

import commandes.retirer_item.RetirerItem;
import commandes.retirer_item.RetirerItemPourEnvoi;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import maliste.modeles.liste.ItemLectureSeule;

public class Item extends VBox {
	
	private CheckBox boutonEffacer;
	private RetirerItemPourEnvoi retirerItemPourEnvoi;
	
	public Item(ItemLectureSeule itemLectureSeule, String styleClassItem) {
		super();
		J.appel(this);
		
		remplirVBox(itemLectureSeule.getTexte(), styleClassItem);
		
		obtenirCommandePourEnvoi();
		
		installerCapteurEvenement(itemLectureSeule.getId());
	}

	private void remplirVBox(String texte, String styleClassItem) {
		J.appel(this);

		VBox.setVgrow(this, Priority.ALWAYS);
		this.getStyleClass().add("item");
		
		this.getChildren().add(petitEspaceVertical());
		
		HBox hboxItem = new HBox();
		VBox.setVgrow(hboxItem, Priority.ALWAYS);
		hboxItem.getStyleClass().add(styleClassItem);
		this.getChildren().add(hboxItem);

		remplirHBox(texte, hboxItem);

		this.getChildren().add(petitEspaceVertical());
	}

	private void remplirHBox(String texte, HBox hboxItem) {
		J.appel(this);

		hboxItem.getChildren().add(petitEspaceHorizontal());

		hboxItem.getChildren().add(new Text(texte));

		hboxItem.getChildren().add(petitEspaceHorizontal());

		boutonEffacer = new CheckBox();
		hboxItem.getChildren().add(boutonEffacer);

		hboxItem.getChildren().add(petitEspaceHorizontal());
	}
	
	private Pane petitEspaceVertical() {
		J.appel(this);
		
		Pane petitEspaceVertical = petitEspace();
		VBox.setVgrow(petitEspaceVertical, Priority.ALWAYS);
		
		return petitEspaceVertical;
	}

	private Pane petitEspaceHorizontal() {
		J.appel(this);
		
		Pane petitEspaceHorizontal = petitEspace();
		HBox.setHgrow(petitEspaceHorizontal, Priority.ALWAYS);
		
		return petitEspaceHorizontal;
	}

	private Pane petitEspace() {
		J.appel(this);

		Pane petitEspace = new Pane();
		petitEspace.getStyleClass().add("petitEspace");
		
		return petitEspace;
	}


	private void obtenirCommandePourEnvoi() {
		J.appel(this);

		retirerItemPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(RetirerItem.class);
	}

	private void installerCapteurEvenement(int id) {
		J.appel(this);
		boutonEffacer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				retirerItemPourEnvoi.setId(id);
				retirerItemPourEnvoi.envoyerCommande();
			}
		});
	}


}
