package quatredesuite_javafx.vues;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.Commande;
import commun_client.commandes.RecepteurCommande;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.layout.ColumnConstraints;
import javafx.geometry.HPos;
import javafx.scene.layout.Priority;
import quatredesuite.enumerations.Couleur;
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrilleRecue;
import quatredesuite_client.vues.VuePartie;
import quatredesuite_javafx.vues.controles.GrilleCases;
import quatredesuite_javafx.vues.controles.GrilleEntetes;

public class VuePartieFX implements VuePartie {

    @FXML
    Text textJoueurUn, textJoueurDeux;
    
    @FXML
    GrilleEntetes grilleEntetes;

    @FXML
    GrilleCases grilleCases;
    
	@Override
	public void creerEvenements() {
		J.appel(this);

        grilleEntetes.creerEvenements();
        
        // FIXME: ça va pas ici!
        grilleCases.installerCapteurs();

	}

	@Override
	public void installerListeners() {
		J.appel(this);

        grilleEntetes.installerListeners();
	}

    @Override
    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);

		ColumnConstraints contraintesColonne = new ColumnConstraints();
            
		// FIXME: devrait être dans le CSS (en em!)
		contraintesColonne.setMinWidth(50);
		contraintesColonne.setPrefWidth(100);
		contraintesColonne.setMaxWidth(200);
		
		contraintesColonne.setHalignment(HPos.CENTER);

		contraintesColonne.setHgrow(Priority.ALWAYS);
        
        grilleEntetes.creerEntetes(largeur, contraintesColonne);
        grilleCases.creerCases(largeur, hauteur, contraintesColonne);

    }

    @Override
    public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
        J.appel(this);
        
        grilleCases.afficherJeton(indiceColonne, indiceRangee, couleur);
    }

	@Override
	public void colorerEntete(int indiceColonne, Couleur couleur) {
		J.appel(this);

		grilleEntetes.colorerEntete(indiceColonne, couleur);
	} 
	


}
