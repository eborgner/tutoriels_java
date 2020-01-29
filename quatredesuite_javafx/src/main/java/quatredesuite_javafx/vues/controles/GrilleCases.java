package quatredesuite_javafx.vues.controles;


import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.Commande;
import commun_client.commandes.RecepteurCommande;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.ColumnConstraints;
import javafx.util.Duration;
import quatredesuite.enumerations.Couleur;
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrilleRecue;

public class GrilleCases extends Grille {


    private Case[][] cases;
    private int hauteur;
    
	public void creerCases(int largeur, int hauteur, ColumnConstraints contraintesColonne) {
		J.appel(this);
		
		this.hauteur = hauteur;
        cases = new Case[largeur][hauteur];
        
        this.getStyleClass().add("fondPartie");
        
        ajusterMiseEnPageColonnes(largeur, contraintesColonne);
        
        ajouterCases(largeur, hauteur);
		
	}



	private void ajouterCases(int largeur, int hauteur) {

        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
            
            for(int indiceRangee = 0; indiceRangee < hauteur; indiceRangee++) {
                
                Case _case = new Case();
                
                this.add(_case, indiceColonne, indiceRangee);
                
                cases[indiceColonne][indiceRangee] = _case;

            }
        }
	}
	
	private int versIndiceRangeeVue(int indiceRangeeModele) {
		J.appel(this);
		
		return hauteur - indiceRangeeModele - 1;
		
	}

	public void afficherJeton(int indiceColonne, int indiceRangeeModele, Couleur couleur) {
		J.appel(this);
		
		int indiceRangeeVue = versIndiceRangeeVue(indiceRangeeModele);

        if(indiceColonne < cases.length && indiceRangeeVue < cases[indiceColonne].length) {
            cases[indiceColonne][indiceRangeeVue].afficherJeton(couleur);
        }
	}

	public void animerVidagePartie(ViderGrilleRecue evenement) {
		J.appel(this);
		
		Timeline timeline = new Timeline();
		
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.ZERO,
						new KeyValue(this.rotateProperty(), 0)));
		
		double rotation = 5;
		
		int i;
		
		for(i = 0 ; i < 7; i++) {
			
			rotation = -1*rotation;

			timeline.getKeyFrames().add(
					new KeyFrame(new Duration(i*50l),
							new KeyValue(this.rotateProperty(), rotation)));
			
		}

		timeline.getKeyFrames().add(
				new KeyFrame(new Duration(i*50l),
						new KeyValue(this.rotateProperty(), 0)));

		
		timeline.play(); 
		
		timeline.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				evenement.finCaptation();

			}
		});
		
		animerSortieJetons();
	}
	
	private void animerSortieJetons() {
		J.appel(this);
		

        for(int indiceColonne = 0; indiceColonne < cases.length; indiceColonne++) {
            for(int indiceRangee = 0; indiceRangee < cases[indiceColonne].length; indiceRangee++) {
            	cases[indiceColonne][indiceRangee].animerSortieJeton();
            }
        }
	}



	public void installerCapteurs() {
        FabriqueCommande.installerRecepteur(ViderGrille.class, new RecepteurCommande<ViderGrilleRecue>() {

			@Override
			public void capterEvenement(ViderGrilleRecue evenement) {
				J.appel(this);
				
				animerVidagePartie(evenement);

			}
		});
	}

}
