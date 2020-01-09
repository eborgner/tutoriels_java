package quatredesuite.donnees;

import quatredesuite_client.vues.VuePartie;
import commun.debogage.J;
import quatredesuite.enumerations.Couleur;

public class Jeton {
	
	private Couleur couleur;

	public void initialiser(Couleur couleur) {
		J.appel(this);

		this.couleur = couleur;
	}

	public void rafraichirAffichage(VuePartie vue, int indiceColonne, int indiceRangee) {
		J.appel(this);
		
		vue.afficherJeton(indiceColonne, indiceRangee, couleur);

		
	}

}
