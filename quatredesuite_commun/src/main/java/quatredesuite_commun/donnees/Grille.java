package quatredesuite.donnees;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import quatredesuite_client.vues.VuePartie;
import quatredesuite.enumerations.Couleur;

public class Grille {
	
	protected List<Colonne> colonnes;

	public void initialiser(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			colonnes.add(new Colonne());
		}
	}

	public void ajouterJeton(int idColonne, Couleur couleur) {
		J.appel(this);
		
		colonnes.get(idColonne).ajouterJeton(couleur);
		
	}

	public void rafraichirAffichage(VuePartie vue, Couleur couleurCourante) {
		J.appel(this);
		
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
			
			colonnes.get(indiceColonne).rafraichirAffichage(vue, couleurCourante, indiceColonne);

		}
	}


	

}
