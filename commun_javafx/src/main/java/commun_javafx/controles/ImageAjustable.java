package commun_javafx.controles;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

import commun.debogage.J;
import javafx.application.Platform;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ImageAjustable extends HBox {
	
	private ImageView imageView;
	private double largeurInitiale;
	private double hauteurInitiale;
	
	public ImageAjustable(@NamedArg("url") String url) {
		super();
		J.appel(this);
		
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		
		Image image = new Image(streamImage);
		
		imageView = new ImageView(image);
		
		this.getChildren().add(imageView);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				memoriserTailleInitiale();
				installerListeners();
			}
		});
	}
	
	private void memoriserTailleInitiale() {
		J.appel(this);

		hauteurInitiale = this.getHeight();
		largeurInitiale = this.getWidth();
	}
	
	private <T> void installerListeners() {
		J.appel(this);
		
		this.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				ajusterImage();
			}
		});
		
		this.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				ajusterImage();
			}
		});
	}

	private void ajusterImage() {
		J.appel(this);
		
		double ratioX = this.getWidth() / largeurInitiale;
		double ratioY = this.getHeight() / hauteurInitiale;
		
		if(ratioX < ratioY) {
			imageView.setScaleX(ratioX);
			imageView.setScaleY(ratioX);

		}else {
			imageView.setScaleX(ratioY);
			imageView.setScaleY(ratioY);

		}
	}
}
