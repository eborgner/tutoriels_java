package commun_javafx;


import commun.debogage.J;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;

import javafx.beans.NamedArg;


public class BoutonDessine extends StackPane {
	
	private Canvas canvas;
	private GraphicsContext gc;
	private String texte;
	private Font police;
	private Paint couleurTexte;
	private Paint couleurFond;
	private Paint couleurBordure;

	public BoutonDessine(@NamedArg("text") String texte, @NamedArg("styleClass") String styleClass){
		super();
		J.appel(this);
		
		Button boutonTemporaire = new Button(texte);

		for(String classe : styleClass.split(",")) {
			boutonTemporaire.getStyleClass().add(classe);
		}
		
		boutonTemporaire.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				J.valeurs("POUET");
			}
		});
		
		//boutonTemporaire.setVisible(false);
		this.getChildren().add(boutonTemporaire);
		
		this.texte = texte;
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				J.appel(this);
				
				double largeur = boutonTemporaire.getWidth();
				double hauteur = boutonTemporaire.getHeight();
				
				canvas = new Canvas(largeur, hauteur);
				gc = canvas.getGraphicsContext2D();
				
				police = boutonTemporaire.getFont();
				
				couleurTexte = boutonTemporaire.getTextFill();
				couleurFond = boutonTemporaire.getBackground().getFills().get(0).getFill();
				couleurBordure = boutonTemporaire.getBorder().getStrokes().get(0).getBottomStroke();
				
				boutonTemporaire.setTextFill(Paint.valueOf("rgba(0,0,0,0)"));
				
				//getChildren().clear();
				getChildren().add(canvas);
				
				animerDessinInitial(largeur, hauteur);
			}
			
		});
		
		/*
		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				J.valeurs(newValue);
				
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						J.appel(this);

					}
				});
			}
		}); */
		
		setOnMousePressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				J.appel(this);

				//boutonTemporaire.fireEvent(event);
				animerDessinInitial(getWidth(), getHeight());
			}
		});
		
		setOnMouseReleased(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				//boutonTemporaire.fireEvent(event);
			}
		});
		
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				//boutonTemporaire.fireEvent(event);
			}
		});
		
	}
	
	
	private void animerDessinInitial(double largeur, double hauteur) {
		J.appel(this);
		
		AnimationInitiale animationInitiale = new AnimationInitiale(gc, largeur, hauteur, texte);
		animationInitiale.start();

	}
	
	private class AnimationInitiale extends AnimationTimer {
		
		private GraphicsContext gc;
		private double largeur, hauteur;
		private String texte;
		
		private long debutNanoSecondes = -1;
		private long dureeNanoSecondes = 300000000;


		AnimationInitiale(GraphicsContext gc, double largeur, double hauteur, String texte){
			super();
			J.appel(this);
			
			this.gc = gc;
			this.largeur = largeur;
			this.hauteur = hauteur;
			this.texte = texte;
			
		}
		
		

		@Override
		public void handle(long maintenantNanoSecondes) {
			if(debutNanoSecondes == -1) {

				debutNanoSecondes = maintenantNanoSecondes;

			}else {

				long delaiNanoSecondes = maintenantNanoSecondes - debutNanoSecondes;
				
				if(delaiNanoSecondes >= dureeNanoSecondes) {
					this.stop();
				}

				double proportionCourante = (double) delaiNanoSecondes / (double) dureeNanoSecondes;
			
				double largeurCourante = proportionCourante * largeur;
				double hauteurCourante = proportionCourante * hauteur;
				
				gc.clearRect(0, 0, largeur, hauteur);

				gc.setFill(couleurFond);
				gc.fillRect(0, 0, largeurCourante, hauteurCourante);

				gc.setFill(couleurBordure);
				gc.fillRect(0.7*largeurCourante, 0.7*hauteurCourante, 0.3*largeurCourante, 0.3*hauteurCourante);
				
				
				gc.setFont(police);

				gc.setFill(couleurTexte);
				gc.fillText(texte, 0, police.getSize());
				
			}
		}
	}


}
