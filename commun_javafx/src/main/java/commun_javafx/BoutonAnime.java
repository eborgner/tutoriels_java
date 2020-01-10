package commun_javafx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javafx.util.Duration;

import commun.debogage.J;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;

public class BoutonAnime extends Button {
	
	private Timeline animationSurvol = new Timeline();

	public BoutonAnime() {
		super();
		J.appel(this);
		
		double delai = 600;
		double opaciteNormale = 1.0;
		double opaciteBasse = 0.6;

		animationSurvol.getKeyFrames().add(new KeyFrame(Duration.ZERO, new KeyValue(opacityProperty(), opaciteNormale)));
		animationSurvol.getKeyFrames().add(new KeyFrame(new Duration(delai), new KeyValue(opacityProperty(), opaciteBasse)));
		animationSurvol.getKeyFrames().add(new KeyFrame(new Duration(delai*2), new KeyValue(opacityProperty(), opaciteNormale)));
		
		animationSurvol.setCycleCount(-1);
		
		this.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				animationSurvol.play();
			}
		});
		
		this.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				animationSurvol.stop();
				setOpacity(1);
			}
		});
	}

}
