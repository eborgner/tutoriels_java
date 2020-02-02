package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import commun_javafx.vues.composants.ImageAjustable;
import javafx.beans.NamedArg;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;
import javafx.event.Event;

public class CaseAjustable extends ImageAjustable {
	
	private Timeline animationSurvol = new Timeline();

	public CaseAjustable(@NamedArg("url") String url) {
		super(url);
		J.appel(this);
		
		creerAnimation();
		installerListeners();
	}

	private void creerAnimation() {
		J.appel(this);

        double delai = 600;
        double opaciteNormale = 1.0;
        double opaciteBasse = 0.6;

        animationSurvol.getKeyFrames().add(new KeyFrame(Duration.ZERO, new KeyValue(opacityProperty(), opaciteNormale)));
        animationSurvol.getKeyFrames().add(new KeyFrame(new Duration(delai), new KeyValue(opacityProperty(), opaciteBasse)));
        animationSurvol.getKeyFrames().add(new KeyFrame(new Duration(delai*2), new KeyValue(opacityProperty(), opaciteNormale)));

        animationSurvol.setCycleCount(-1);
	}

	private void installerListeners() {
		J.appel(this);
		
		this.imageView.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				animationSurvol.playFromStart();
			}
		});

		this.imageView.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);
				animationSurvol.stop();
				CaseAjustable.this.setOpacity(1);
			}
		});
		
	}

}
