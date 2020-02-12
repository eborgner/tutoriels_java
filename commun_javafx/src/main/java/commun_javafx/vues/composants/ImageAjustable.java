package commun_javafx.vues.composants;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

import commun.debogage.J;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;

public abstract class ImageAjustable extends HBox {
	
	protected ImageView imageView;
	protected double largeurInitialeConteneur;
	protected double hauteurInitialeConteneur;
	
	private double largeurMin = 60;
	private double hauteurMin = 60;
	private double taillePourcentage = 1.0;

	public ImageAjustable(String url) {
		super();
		J.appel(this);
		
		initialiser(url);
	}
	
	public ImageAjustable(String url, double largeurMin, double hauteurMin, double taillePourcentage) {
		super();
		J.appel(this);
		
		this.largeurMin = largeurMin;
		this.hauteurMin = hauteurMin;
		this.taillePourcentage = taillePourcentage / 100;
		
		initialiser(url);
	}

	private void initialiser(String url) {
		J.appel(this);

		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		
		Image image = new Image(streamImage);
		
		imageView = new ImageView(image);
		
		imageView.setScaleX(taillePourcentage * largeurMin / image.getWidth());
		imageView.setScaleY(taillePourcentage * hauteurMin / image.getHeight());
		
		imageView.setFitWidth(largeurMin);
		imageView.setFitHeight(hauteurMin);
		
		this.getChildren().add(imageView);
		
		this.setAlignment(Pos.CENTER);
		
		imageView.setPreserveRatio(true);
		
		installerListenerLargeur();
		installerListenerHauteur();
	}


	private void installerListenerLargeur() {
		this.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				double ancienneLargeur = (double) oldValue;
				double nouvelleLargeur = (double) newValue;
				
				if(ancienneLargeur == 0) {

					largeurInitialeConteneur = nouvelleLargeur;

				}else {

					ajusterTailleImage();
				}
			}
		});
	}

	private void installerListenerHauteur() {
		J.appel(this);
		
		this.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				double ancienneHauteur = (double) oldValue;
				double nouvelleHauteur = (double) newValue;
				
				if(ancienneHauteur == 0) {
					
					hauteurInitialeConteneur = nouvelleHauteur;

				}else {
					
					ajusterTailleImage();

				}
			}
		});
		
	}
	
	protected void ajusterTailleImage() {
		J.appel(this);
		
		double largeurCourante = this.getWidth();
		double hauteurCourante = this.getHeight();
		
		if(largeurCourante < hauteurCourante) {
			
			setScaleXY(largeurCourante / largeurInitialeConteneur);
			
		}else {

			setScaleXY(hauteurCourante / hauteurInitialeConteneur);
			
		}
	}

	protected void setScaleXY(double facteurTaille) {
		J.appel(this);
		
		this.imageView.setScaleX(taillePourcentage * facteurTaille);
		this.imageView.setScaleY(taillePourcentage * facteurTaille);
	}
}
