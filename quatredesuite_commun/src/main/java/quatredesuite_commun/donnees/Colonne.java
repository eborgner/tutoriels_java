package quatredesuite.donnees;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import quatredesuite_client.vues.VuePartie;
import quatredesuite.enumerations.Couleur;

public class Colonne {
	
	private List<Jeton> jetons = new ArrayList<>();

	public void ajouterJeton(Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();
		
		jeton.initialiser(couleur);
		
		jetons.add(jeton);
	}

	public void rafraichirAffichage(VuePartie vue, Couleur couleurCourante, int indiceColonne) {
		J.appel(this);
		
		vue.colorerEntete(indiceColonne, couleurCourante);

		for(int indiceRangee = 0; indiceRangee < jetons.size(); indiceRangee++) {
			
			jetons.get(indiceRangee).rafraichirAffichage(vue, indiceColonne, indiceRangee);
			
		}
		
		
	}

}
