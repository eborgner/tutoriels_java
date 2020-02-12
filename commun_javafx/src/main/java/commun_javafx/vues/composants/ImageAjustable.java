package commun_javafx.vues.composants;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

import commun.debogage.J;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;

public class ImageAjustable extends HBox {
	
	protected ImageView imageView;
	protected double largeurInitialeConteneur;
	protected double hauteurInitialeConteneur;
	
	public ImageAjustable(@NamedArg("url") String url) {
		super();
		J.appel(this);
		
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		
		Image image = new Image(streamImage);
		
		imageView = new ImageView(image);
		
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

					largeurInitiale = nouvelleLargeur;

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
					
					hauteurInitiale = nouvelleHauteur;

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
			
			setScaleXY(largeurCourante / largeurInitiale);
			
		}else {

			setScaleXY(hauteurCourante / hauteurInitiale);
			
		}
	}


	protected void setScaleXY(double facteurTaille) {
		J.appel(this);
		
		this.setScaleX(facteurTaille);
		this.setScaleY(facteurTaille);
	}
}
