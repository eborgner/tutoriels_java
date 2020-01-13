package commun_javafx;



import commun.debogage.J;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
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
	private double marges;
	private double padding;
	private double largeurTexte;
	private double hauteurTexte;
	
	private double largeur;
	private double hauteur;
	private double debutX;
	private double debutY;
	
	private AnimationInitiale animation;


	public BoutonDessine(@NamedArg("text") String texte, @NamedArg("styleClass") String styleClass){
		super();
		J.appel(this);
		
		Button boutonTemporaire = new Button(texte);
		Label texteTemporaire = new Label(texte);

		for(String classe : styleClass.split(",")) {
			boutonTemporaire.getStyleClass().add(classe);
		}
		
		texteTemporaire.setPadding(new Insets(0, 0, 0, 0));
		texteTemporaire.setBorder(null);
		
		//boutonTemporaire.setVisible(false);
		this.getChildren().add(texteTemporaire);
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
				marges = boutonTemporaire.getBorder().getInsets().getTop() - boutonTemporaire.getBorder().getStrokes().get(0).getWidths().getTop();
				padding = boutonTemporaire.getPadding().getTop();

				largeurTexte = texteTemporaire.getWidth();
				hauteurTexte = texteTemporaire.getHeight();

				J.valeurs(largeurTexte, hauteurTexte);
				
				BoutonDessine.this.largeur = largeur - 2*marges;
				BoutonDessine.this.hauteur = hauteur - 2*marges;

				debutX = marges;
				debutY = marges;
				
				boutonTemporaire.setTextFill(Paint.valueOf("rgba(0,0,0,0)"));
				
				getChildren().clear();
				getChildren().add(canvas);
				
				animation = new AnimationInitiale();

				dessinerBouton();
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
		
		
		setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				J.appel(this);

				//boutonTemporaire.fireEvent(event);
				animation.start();
			}
		});

		setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				J.appel(this);
				animation.stop();
				dessinerBouton();
			}
		});
		
		
	}
	
	private void dessinerBouton() {
		J.appel(this);
		dessinerFond();
		dessinerTexte();
		
	}
	
	private void dessinerFond() {
		J.appel(this);

		gc.clearRect(0, 0, largeur + marges*2, hauteur + marges*2);
		gc.setFill(couleurBordure);
		gc.fillArc(debutX, debutY, largeur, hauteur, 0, 360, ArcType.ROUND);
	}
	
	private void dessinerTexte() {
		J.appel(this);

		double texteX = debutX + (largeur - largeurTexte) / 2;
		double texteY = debutY + hauteur / 2 + hauteurTexte / 2;
		gc.setFont(police);
		
		gc.setFill(couleurTexte);
				gc.fillText(texte, texteX, texteY);
		
		
	}
	
	private class AnimationInitiale extends AnimationTimer {
		
		private long debutNanoSecondes = -1;
		private long dureeNanoSecondes = 700000000;
		
		private double largeurArc = 60;
		


		AnimationInitiale(){
			super();
			J.appel(this);
		}
		
		

		@Override
		public void handle(long maintenantNanoSecondes) {
			if(debutNanoSecondes == -1) {

				debutNanoSecondes = maintenantNanoSecondes;
				

			}else {

				long delaiNanoSecondes = maintenantNanoSecondes - debutNanoSecondes;
				
				if(delaiNanoSecondes >= dureeNanoSecondes) {
					this.stop();
					this.start();
				}

				double proportionCourante = (double) delaiNanoSecondes / (double) dureeNanoSecondes;
			
				double largeurCourante = proportionCourante * largeur;
				double hauteurCourante = proportionCourante * hauteur;
				
				double debutX = marges;
				double debutY = marges;
				
				double angleCourant = proportionCourante * 360;

				double milieuX = debutX + largeur/2;
				double milieuY = debutY + hauteur/2;
				

				dessinerFond();

				gc.setFill(couleurFond);
				gc.fillArc(debutX, debutY, largeur, hauteur, angleCourant, largeurArc, ArcType.ROUND);
				
				dessinerTexte();
				
				

				//gc.setFill(couleurBordure);
				//gc.fillRect(0.7*largeurCourante, 0.7*hauteurCourante, 0.3*largeurCourante, 0.3*hauteurCourante);
				
				
				
				
				
			}
		}
	}


}
