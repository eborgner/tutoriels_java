package quatredesuite_javafx.vues.composants;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import commun.debogage.J;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import quatredesuite.enumerations.Couleur;

public class Case extends HBox {
	
	
	private static Map<Couleur, Image> imagePourCouleur = new HashMap<>();
	private static Image imageCaseVide = chargerImage("/images/VIDE.png");

	private static Image chargerImage(String cheminImage) {

		URL urlImage = Case.class.getResource(cheminImage);
			
		if(urlImage == null) {

			J.valeurs("[FATAL] impossible de charger l'image: " + cheminImage);
			System.exit(0);

		}
		
		Image image = new Image(urlImage.toString());
		
		return image;
		
	}
	
	static {
		
		for(Couleur couleur : Couleur.values()) {

			String cheminImage = "/images/" + couleur.name() + ".png";
			Image image = chargerImage(cheminImage);
			imagePourCouleur.put(couleur, image);
		}
		
		
	}
	
	private boolean siCaseVide = true;
	
	public Case(){
		J.appel(this);
		
		this.setAlignment(Pos.CENTER);

		this.getChildren().add(new ImageView(imageCaseVide));

	}
	
	
	public void afficherJeton(Couleur couleur) {
		J.appel(this);
		
		if(siCaseVide) {
			
			siCaseVide = false;
		
			this.getStyleClass().add(couleur.name());
		
			this.getChildren().clear();
			this.getChildren().add(new ImageView(imagePourCouleur.get(couleur)));
			
			animerEntreeJeton();
			
		}
	}
	
	private void animerEntreeJeton() {
		J.appel(this);
		
		Timeline timeline = new Timeline();

		timeline.getKeyFrames().add(
				new KeyFrame(Duration.ZERO,
						new KeyValue(this.translateYProperty(), -100),
						new KeyValue(this.opacityProperty(), 0)));

		timeline.getKeyFrames().add(
				new KeyFrame(new Duration(100),
						new KeyValue(this.translateYProperty(), 0),
						new KeyValue(this.opacityProperty(), 1)));
		
		timeline.play();
		
		
		
	}

	public void animerSortieJeton() {
		J.appel(this);
		
		Timeline timeline = new Timeline();

		timeline.getKeyFrames().add(
				new KeyFrame(Duration.ZERO,
						new KeyValue(this.translateYProperty(), 0),
						new KeyValue(this.opacityProperty(), 1)));

		timeline.getKeyFrames().add(
				new KeyFrame(new Duration(100),
						new KeyValue(this.translateYProperty(), 150),
						new KeyValue(this.opacityProperty(), 0)));
		
		timeline.play();
	}
	

}
