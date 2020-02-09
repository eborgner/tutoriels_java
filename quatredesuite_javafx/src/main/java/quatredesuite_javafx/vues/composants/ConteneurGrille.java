package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import quatredesuite.enumerations.Couleur;
import quatredesuite_client.commandes.vider_grille.ViderGrilleRecue;

public class ConteneurGrille extends VBox {
	
	private Color couleurRouge;
	private Color couleurJaune;
	
	private Timeline animationViderGrille;
	
	public ConteneurGrille(@NamedArg("couleurRouge") String couleurRouge, @NamedArg("couleurJaune") String couleurJaune) {
		super();

		if(couleurRouge != null && !couleurRouge.isEmpty()) {
			this.couleurRouge = Color.valueOf(couleurRouge);
		}
		
		if(couleurJaune != null && !couleurJaune.isEmpty()) {
			this.couleurJaune = Color.valueOf(couleurJaune);
		}
		
		creerAnimationViderGrille();
	}


	public void creerGrille(int largeur, int hauteur) {
		J.appel(this);
		
		this.getStyleClass().add("conteneurGrille");
		
		VBox.setVgrow(this, Priority.ALWAYS);
		
		for(int i = 0; i < hauteur; i++) {

			this.getChildren().add(new ConteneurLigne(largeur, couleurRouge, couleurJaune));
		}
	}

	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		if(siIndiceRangeeValide(indiceRangee)) {
			
			ConteneurLigne conteneurLigne = (ConteneurLigne) this.getChildren().get(indiceRangee);
			conteneurLigne.afficherJeton(indiceColonne, couleur);
		}
	}

	private boolean siIndiceRangeeValide(int indiceRangee) {
		J.appel(this);

		return indiceRangee >= 0 && indiceRangee < this.getChildren().size();
	}


	public void viderGrille(ViderGrilleRecue commande) {
		J.appel(this);
		
		animationViderGrille.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				commande.notifierCommandeTraitee();
			}
		});	
		
		animerSortieJetons();
		animationViderGrille.playFromStart();
	}

	private void animerSortieJetons() {
		J.appel(this);
		
		for(int indiceRangee = 0; indiceRangee < this.getChildren().size(); indiceRangee++) {
			
			ConteneurLigne ligne = (ConteneurLigne) this.getChildren().get(indiceRangee);
			
			ligne.animerSortieJetons();
		}
	}


	private void creerAnimationViderGrille() {
		J.appel(this);
		
		animationViderGrille = new Timeline();
		
		animationViderGrille.getKeyFrames().add(new KeyFrame(Duration.ZERO,
						                                     new KeyValue(this.rotateProperty(), 0)));
		
		double rotation = 5;
		
		int i;
		
		for(i = 0 ; i < 7; i++) {
			
			rotation = -1*rotation;

			animationViderGrille.getKeyFrames().add(
					new KeyFrame(new Duration(i*50l),
							new KeyValue(this.rotateProperty(), rotation)));
			
		}

		animationViderGrille.getKeyFrames().add(
				new KeyFrame(new Duration(i*50l),
						new KeyValue(this.rotateProperty(), 0)));
	}


	public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
		J.appel(this);

		if(siIndiceRangeeValide(indiceRangee)) {
			
			ConteneurLigne ligne = (ConteneurLigne) this.getChildren().get(indiceRangee);
			ligne.animerEntreeJeton(indiceColonne);
			
		}
		
	}
}
