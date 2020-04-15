package quatredesuite_javafx.vues.composants;


import commun.debogage.J;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import quatredesuite.modeles.sauvegardes.UneSauvegardeLectureSeule;

public class ConteneurSauvegardes extends VBox {

	private final double FACTEUR_INITIAL = 1.5;
	private int nombreCaracteresMax;
	private double facteurLargeurTaillePolice;
	
	public ConteneurSauvegardes() {
		super();
		J.appel(this);
		
		installerObservateurTaille();
	}


	private void installerObservateurTaille() {
		J.appel(this);
		
		this.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				if(getHeight() != 0) {
					
					reagirNouvelleTaille();
				}
			}
		});
		
		this.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				J.appel(this);
				
				if(getWidth() != 0) {
					
					reagirNouvelleTaille();
				}
			}
		});
	}

	protected void reagirNouvelleTaille() {
		J.appel(this);
		
		double taillePolice = facteurLargeurTaillePolice * getWidth();
		
		double hauteurUneSauvegarde = getHeight() / getChildren().size();
		
		if(taillePolice > 0.8 * hauteurUneSauvegarde) {
			taillePolice = 0.8 * hauteurUneSauvegarde;
		}
		
		for(Node enfant : getChildren()) {
			
			((ConteneurUneSauvegarde) enfant).ajusterTaillePolice(taillePolice);
		}
	}
	
	private void ajusterFacteurLargeurTaillePolice(int nombreCaracteres) {
		J.appel(this);
		
		if(nombreCaracteres > nombreCaracteresMax) {
			
			nombreCaracteresMax = nombreCaracteres;
		}
		
		facteurLargeurTaillePolice = FACTEUR_INITIAL / nombreCaracteresMax;
	}
	
	
	public void ajouterSauvegarde(UneSauvegardeLectureSeule uneSauvegarde, String texteBoutonOuvrir) {
		J.appel(this);
		
		int nombreDeCaracteres = uneSauvegarde.getCheminDansHome().length() + texteBoutonOuvrir.length();
		
		ajusterFacteurLargeurTaillePolice(nombreDeCaracteres);
		
		ConteneurUneSauvegarde conteneur = new ConteneurUneSauvegarde(uneSauvegarde, styleClassLigne(), texteBoutonOuvrir);

		this.getChildren().add(conteneur);
	}
	
	private String styleClassLigne() {
		J.appel(this);

		boolean siPair = this.getChildren().size()%2 == 0;
		
		String styleClassItem = "rangeeImpaire";
		
		if(siPair) {
			styleClassItem = "rangeePaire";
		}
		
		return styleClassItem;
	}

	public void viderLesSauvegardes() {
		J.appel(this);

		this.getChildren().clear();
	}
}
