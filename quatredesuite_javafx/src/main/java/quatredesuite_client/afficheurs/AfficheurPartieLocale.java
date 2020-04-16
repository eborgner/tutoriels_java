package quatredesuite_client.afficheurs;

import java.util.List;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import quatredesuite.enumerations.Couleur;
import quatredesuite.modeles.partie.ColonneLectureSeule;
import quatredesuite.modeles.partie.GrilleLectureSeule;
import quatredesuite.modeles.partie.JetonLectureSeule;
import quatredesuite.modeles.partie.PartieLocaleLectureSeule;
import quatredesuite_client.vues.VuePartieLocale;

public abstract class AfficheurPartieLocale<V extends VuePartieLocale> 

							extends Afficheur<PartieLocaleLectureSeule, 
											  V> {

	@Override
	public void initialiserAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
		J.appel(this);
		
		int largeur = partieLectureSeule.getLargeur();
		int hauteur = partieLectureSeule.getHauteur();
		
		vue.creerGrille(largeur, hauteur);
		
		rafraichirAffichage(partieLectureSeule, vue);
	}

	@Override
	public void rafraichirAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
		J.appel(this);

		GrilleLectureSeule grille = partieLectureSeule.getGrille();
		
		int hauteurGrille = partieLectureSeule.getHauteur();
		
		rafraichirGrille(hauteurGrille, grille, vue);
	}

	private void rafraichirGrille(int hauteurGrille, GrilleLectureSeule grille, VuePartieLocale vue) {
		J.appel(this);

		List<ColonneLectureSeule> colonnes = grille.getColonnes();
		
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
		
			ColonneLectureSeule colonne = colonnes.get(indiceColonne);
			List<JetonLectureSeule> jetons = colonne.getJetons();
			
			rafraichirColonne(hauteurGrille, indiceColonne, jetons, vue);

		}
	}

	private void rafraichirColonne(int hauteurGrille, 
								   int indiceColonne, 
								   List<JetonLectureSeule> jetons, 
								   VuePartieLocale vue) {
		J.appel(this);
		
		
		for(int indiceRangee = 0; indiceRangee < jetons.size(); indiceRangee++) {
			
			JetonLectureSeule jeton = jetons.get(indiceRangee);
			Couleur couleur = jeton.getCouleur();
			
			afficherJeton(hauteurGrille, indiceColonne, indiceRangee, couleur, vue);
		}
	}
	
	private void afficherJeton(int hauteurGrille, 
			                   int indiceColonne,  
			                   int indiceRangee, 
			                   Couleur couleur,
			                   VuePartieLocale vue) {
		J.appel(this);
		
		int indiceRangeeCoordonneesGraphiques = convertirEnCoordonneesGraphiques(hauteurGrille, indiceRangee);

		vue.afficherJeton(indiceColonne, indiceRangeeCoordonneesGraphiques, couleur);
	}
	
	private int convertirEnCoordonneesGraphiques(int hauteurGrille, int indiceRangee) {
		J.appel(this);

		return hauteurGrille - indiceRangee - 1;
	}
}
