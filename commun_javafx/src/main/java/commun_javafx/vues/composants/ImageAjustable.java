package commun_javafx.vues.composants;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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

	private double largeurInitialeImage = 1.0;
	private double hauteurInitialeImage = 1.0;
	
	private double largeurReelleImage;
	private double hauteurReelleImage;

	public ImageAjustable(String url) {
		super();
		J.appel(this);
		
		initialiser(url);
	}
	
	private void initialiser(String url) {
		J.appel(this);

		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		
		Image image = new Image(streamImage);
		
		largeurReelleImage = image.getWidth();
		hauteurReelleImage = image.getHeight();
		
		imageView = new ImageView(image);
		
		imageView.setScaleX(largeurInitialeImage / largeurReelleImage);
		imageView.setScaleY(hauteurInitialeImage / hauteurReelleImage);
		
		HBox.setHgrow(imageView, Priority.ALWAYS);
		
		this.getChildren().add(imageView);
		
		this.setAlignment(Pos.CENTER);
		
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
					ajusterTailleImage();

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
					ajusterTailleImage();

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
		
		double facteurTailleLargeur = largeurCourante / largeurReelleImage;
		double facteurTailleHauteur = hauteurCourante / hauteurReelleImage;
		
		J.valeurs(facteurTailleLargeur, facteurTailleHauteur);
		

		if(facteurTailleLargeur < facteurTailleHauteur) {
			
			setScaleXY(facteurTailleLargeur);

		}else {

			setScaleXY(facteurTailleHauteur);
		}
	}

	protected void setScaleXY(double facteurTaille) {
		J.appel(this);
		
		this.imageView.setScaleX(facteurTaille);
		this.imageView.setScaleY(facteurTaille);
	}
}
