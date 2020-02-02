package commun_javafx.vues.composants;


import commun.debogage.J;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class CanvasAjustable extends Pane {
	
	/* nécessaire ? 
	private class ResizableCanvas extends Canvas {
		@Override
		public boolean isResizable() {
			return true;
		}
	}
	*/
	
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

		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		
	}
	
	private void installerObservateurLargeur() {
		J.appel(this);
		
		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				double ancienneLargeur = (double) oldValue;
				double nouvelleLargeur = (double) newValue;

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
				
				reagirNouvelleHauteur(ancienneHauteur, nouvelleHauteur);
			}
		});
	}

	protected abstract void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur);
	protected abstract void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur);

}
