package commun_javafx;


import commun.debogage.J;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;

import javafx.beans.NamedArg;


public class BoutonAnime extends Canvas {
	
	private GraphicsContext gc;
	private String texte;

	public BoutonAnime(@NamedArg("texte") String texte){
		super();
		J.appel(this);
		
		this.gc = getGraphicsContext2D();
		this.texte = texte;
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				J.appel(this);

				animerDessinInitial(getWidth(), getHeight());

			}
			
		});
		
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
		});
		
		
		setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				J.appel(this);
				
				gc.clearRect(0, 0, getWidth(), getHeight());
				animerDessinInitial(getWidth(), getHeight());

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
			
			gc.setFill(Color.BLACK);
			
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

				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, largeurCourante, hauteurCourante);

				gc.setFill(Color.WHITE);
				gc.fillText(texte, 0, 10);
				
			}
		}
	}


}
