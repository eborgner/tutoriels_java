package quatredesuite_client.afficheurs.partie;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import quatredesuite.enumerations.Couleur;
import quatredesuite.modeles.partie.Grille;
import quatredesuite.modeles.partie.GrilleLectureSeule;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.vues.VuePartie;

public class AfficheurPartie extends Afficheur<PartieLectureSeule, VuePartie>{

	@Override
	public void initialiserAffichage(PartieLectureSeule partieLectureSeule, VuePartie vue) {
		J.appel(this);
		
		int largeur = partieLectureSeule.getLargeur();
		int hauteur = partieLectureSeule.getHauteur();
		
		// TODO: créer grille
	}

	@Override
	public void rafraichirAffichage(PartieLectureSeule partieLectureSeule, VuePartie vue) {
		J.appel(this);

		GrilleLectureSeule grille = partieLectureSeule.getGrille();
		
		rafraichirGrille(grille, vue);
	}

	private void rafraichirGrille(GrilleLectureSeule grille, VuePartie vue) {
		J.appel(this);
		
		for(int indiceRangee = 0; indiceRangee < jetons.size(); indiceRangee++) {
			
			jetons.get(indiceRangee).rafraichirAffichage(vue, indiceColonne, indiceRangee);
			
		}
	}

	public void rafraichirAffichage(VuePartie vue, Couleur couleurCourante) {
		J.appel(this);
		
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
			
			colonnes.get(indiceColonne).rafraichirAffichage(vue, couleurCourante, indiceColonne);

		}
	}


	public void rafraichirAffichage(Jeton jeton, int indiceColonne, int indiceRangee, VuePartie vue) {
		J.appel(this);
		
		vue.afficherJeton(indiceColonne, indiceRangee, couleur);

		
	}
	


}
