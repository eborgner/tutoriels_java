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
		
		imageView.setPreserveRatio(true);
		
		imageView.fitWidthProperty().bind(this.widthProperty());
		imageView.fitHeightProperty().bind(this.heightProperty());
	}
	
}
