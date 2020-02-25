package maliste_javafx.vues.composants;

import commandes.retirer_item.RetirerItem;
import commandes.retirer_item.RetirerItemPourEnvoi;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import maliste.modeles.liste.ItemLectureSeule;

public class ItemGraphique extends VBox {
	
	private Text texte;
	private Button boutonEffacer;
	private RetirerItemPourEnvoi retirerItemPourEnvoi;
	
	private Timeline animation = new Timeline();

	public ItemGraphique(ItemLectureSeule itemLectureSeule, String styleClassItem) {
		super();
		J.appel(this);
		
		texte = new Text(itemLectureSeule.getTexte());
		texte.getStyleClass().add(styleClassItem);
		
		remplirVBox(styleClassItem);
		
		obtenirCommandePourEnvoi(itemLectureSeule.getId());
		
		installerCapteurEvenement();
		
		installerObservateurTaille();
	}

	private void creerAnimation() {
		J.appel(this);
		
		animation.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				retirerItemPourEnvoi.envoyerCommande();
			}
		});
		
		animation.getKeyFrames().add(new KeyFrame(new Duration(300), new KeyValue(this.translateXProperty(), 0)));
		animation.getKeyFrames().add(new KeyFrame(new Duration(300), new KeyValue(this.opacityProperty(), 1)));
		animation.getKeyFrames().add(new KeyFrame(new Duration(600), new KeyValue(this.translateXProperty(), -getWidth())));
		animation.getKeyFrames().add(new KeyFrame(new Duration(600), new KeyValue(this.opacityProperty(), 0)));
	}

	private void installerObservateurTaille() {
		J.appel(this);
		
		this.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				if(getHeight() != 0) {
					
					reagirNouvelleTaille();
				}
			}
		});
		
		this.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				if(getWidth() != 0) {
					
					reagirNouvelleTaille();
				}
			}
		});
	}

	protected void reagirNouvelleTaille() {
		J.appel(this);

		texte.setFont(new Font(0.5*getHeight()));
		
		creerAnimation();
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				boutonEffacer.requestLayout();
			}
		});
	}

	private void remplirVBox(String styleClassItem) {
		J.appel(this);

		VBox.setVgrow(this, Priority.ALWAYS);
		this.getStyleClass().add("item");
		this.getStyleClass().add(styleClassItem);
		
		this.getChildren().add(petitEspaceVertical());
		
		HBox hboxItem = new HBox();
		this.getChildren().add(hboxItem);

		remplirHBox(hboxItem);

		this.getChildren().add(petitEspaceVertical());
	}

	private void remplirHBox(HBox hboxItem) {
		J.appel(this);

		hboxItem.getChildren().add(petitEspaceHorizontal());

		hboxItem.getChildren().add(texte);

		hboxItem.getChildren().add(espaceHorizontalSansBorne());

		hboxItem.getChildren().add(conteneurBouton());

		hboxItem.getChildren().add(petitEspaceHorizontal());
	}
	
	private VBox conteneurBouton() {
		J.appel(this);
		
		VBox conteneurBouton = new VBox();
		
		HBox.setHgrow(conteneurBouton, Priority.ALWAYS);
		
		conteneurBouton.setAlignment(Pos.CENTER_RIGHT);
		
		conteneurBouton.getChildren().add(petitEspaceVertical());

		boutonEffacer = new Button();

		boutonEffacer.getStyleClass().add("boutonEffacer");
		
		VBox.setVgrow(boutonEffacer, Priority.ALWAYS);
		
		boutonEffacer.setMaxHeight(Double.POSITIVE_INFINITY);
		boutonEffacer.maxWidthProperty().bind(boutonEffacer.heightProperty());
		
		conteneurBouton.getChildren().add(boutonEffacer);
		
		conteneurBouton.getChildren().add(petitEspaceVertical());
		
		return conteneurBouton;
	}
	
	private Pane espaceHorizontalSansBorne() {
		J.appel(this);
		
		Pane espaceHorizontalSansBorne = espaceSansBorne();
		HBox.setHgrow(espaceHorizontalSansBorne, Priority.ALWAYS);
		
		return espaceHorizontalSansBorne;
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

	private Pane espaceSansBorne() {
		J.appel(this);

		Pane espaceSansBorne = new Pane();
		espaceSansBorne.getStyleClass().add("espaceSansBorne");
		
		return espaceSansBorne;
	}


	private void obtenirCommandePourEnvoi(int id) {
		J.appel(this);

		retirerItemPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(RetirerItem.class);
		retirerItemPourEnvoi.setId(id);
	}

	private void installerCapteurEvenement() {
		J.appel(this);
		boutonEffacer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				boutonEffacer.setFont(new Font(0.5*boutonEffacer.getHeight()));
				boutonEffacer.setText("✓");
				animation.playFromStart();
			}
		});
	}
}
