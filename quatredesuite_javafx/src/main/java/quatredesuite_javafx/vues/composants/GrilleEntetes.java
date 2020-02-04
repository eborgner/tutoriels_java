package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import quatredesuite.enumerations.Couleur;

public class GrilleEntetes extends Grille {

    private Entete[] entetes;

	public void creerEntetes(int largeur, ColumnConstraints contraintesColonne) {

        entetes = new Entete[largeur];
        
        ajusterMiseEnPageColonnes(largeur, contraintesColonne);
        
        ajusterMiseEnPageEntetes();
        
        ajouterEntetes(largeur);
		
	}

	private void ajusterMiseEnPageEntetes() {
		J.appel(this);
		
		RowConstraints contraintesEntete = new RowConstraints();
		
		contraintesEntete.setMinHeight(100);
		contraintesEntete.setPrefHeight(100);
		contraintesEntete.setMaxHeight(200);
		
		contraintesEntete.setValignment(VPos.CENTER);
		
		this.getRowConstraints().add(contraintesEntete);

	}

	private void ajouterEntetes(int largeur) {

        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
            
            Entete entete = new Entete(indiceColonne);

            entetes[indiceColonne] = entete;

            this.add(entete, indiceColonne, 0);
            
        }
	}

	public void creerEvenements() {
		J.appel(this);

        for(int indiceColonne = 0; indiceColonne < entetes.length; indiceColonne++) {
        	entetes[indiceColonne].creerEvenements();
        }
	}

	public void installerListeners() {
		J.appel(this);

        for(int indiceColonne = 0; indiceColonne < entetes.length; indiceColonne++) {
            entetes[indiceColonne].installerListener();
        }
		
	}

	public void rafraichirCommandes() {
		J.appel(this);
		
        for(int indiceColonne = 0; indiceColonne < entetes.length; indiceColonne++) {
            entetes[indiceColonne].rafraichirCommande();
        }
	}

	public void colorerEntete(int indiceColonne, Couleur couleur) {
		J.appel(this);
		
		entetes[indiceColonne].colorerEntete(couleur);
		
	}
}
