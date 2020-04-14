package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import quatredesuite.modeles.sauvegardes.UneSauvegardeLectureSeule;

public class AfficheurUneSauvegarde extends VBox {
	
	private Text texte;
	private Button boutonOuvrir;
	

	public AfficheurUneSauvegarde(UneSauvegardeLectureSeule uneSauvegardeLectureSeule, 
							      String styleClassLigne,
							      String texteBoutonOuvrir) {
		super();
		J.appel(this);
		
		texte = new Text(uneSauvegardeLectureSeule.getCheminDansHome());
		texte.getStyleClass().add(styleClassLigne);
		
		boutonOuvrir = new Button(texteBoutonOuvrir);
		
		remplirVBox(styleClassLigne);

		installerCapteurEvenement();
		
		installerObservateurTaille();
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

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				boutonOuvrir.requestLayout();
			}
		});
		
	}

	private void remplirVBox(String styleClassItem) {
		J.appel(this);

		VBox.setVgrow(this, Priority.ALWAYS);
		this.getStyleClass().add("conteneurUneRangee");
		this.getStyleClass().add(styleClassItem);
		
		this.getChildren().add(petitEspaceVertical());
		
		HBox hboxItem = new HBox();
		hboxItem.getStyleClass().add("conteneurUnItem");
		VBox.setVgrow(hboxItem, Priority.ALWAYS);
		this.getChildren().add(hboxItem);

		remplirHBox(hboxItem);

		this.getChildren().add(petitEspaceVertical());
	}

	private void remplirHBox(HBox hboxItem) {
		J.appel(this);

		hboxItem.getChildren().add(petitEspaceHorizontal());

		hboxItem.getChildren().add(texte);

		hboxItem.getChildren().add(conteneurBouton());

		hboxItem.getChildren().add(petitEspaceHorizontal());
	}
	
	private VBox conteneurBouton() {
		J.appel(this);
		
		VBox conteneurBouton = new VBox();
		
		HBox.setHgrow(conteneurBouton, Priority.ALWAYS);
		
		conteneurBouton.getStyleClass().add("conteneurBoutonEffacer");
		
		conteneurBouton.getChildren().add(petitEspaceVertical());

		boutonOuvrir.getStyleClass().add("boutonEffacer");
		
		VBox.setVgrow(boutonOuvrir, Priority.ALWAYS);
		
		boutonOuvrir.setMaxHeight(Double.POSITIVE_INFINITY);
		
		conteneurBouton.getChildren().add(boutonOuvrir);
		
		conteneurBouton.getChildren().add(petitEspaceVertical());
		
		return conteneurBouton;
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

	private void obtenirCommandePourEnvoi(int id) {
		J.appel(this);

		//retirerItemPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(RetirerItem.class);
		//retirerItemPourEnvoi.setId(id);
	}

	private void installerCapteurEvenement() {
		J.appel(this);
		boutonOuvrir.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				// TODO
			}
		});
	}
}
