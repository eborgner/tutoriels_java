package pong_javafx.vues.composants;


import commun.debogage.J;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;

public abstract class CanvasAjustable extends HBox {
	
	private Canvas canvas;
	protected GraphicsContext pinceau;
	
	public CanvasAjustable() {
		J.appel(this);
		
		installerCanvas();
		
		installerObservateurLargeur();
		installerObservateurHauteur();
	}

	private void installerCanvas() {
		J.appel(this);
		
		canvas = new Canvas();
		pinceau = canvas.getGraphicsContext2D();
		
		this.getChildren().add(canvas);
	}
	
	private void installerObservateurLargeur() {
		J.appel(this);
		
		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				double ancienneLargeur = (double) oldValue;
				double nouvelleLargeur = (double) newValue;
				
				J.valeurs(ancienneLargeur, nouvelleLargeur, getWidth());
				
				canvas.setWidth(nouvelleLargeur - 10);
				
				pinceau.fillRect(0, 0, nouvelleLargeur, 100);

				reagirNouvelleLargeur(ancienneLargeur, nouvelleLargeur);
			}
		});
	}

	private void installerObservateurHauteur() {
		J.appel(this);

		heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);

				double ancienneHauteur = (double) oldValue;
				double nouvelleHauteur = (double) newValue;
				
				J.valeurs(ancienneHauteur, nouvelleHauteur, getHeight());

				pinceau.fillRect(0, 0, 100, nouvelleHauteur);
				
				canvas.setHeight(nouvelleHauteur - 10);

				reagirNouvelleHauteur(ancienneHauteur, nouvelleHauteur);
			}
		});
	}

	protected abstract void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur);
	protected abstract void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur);

}