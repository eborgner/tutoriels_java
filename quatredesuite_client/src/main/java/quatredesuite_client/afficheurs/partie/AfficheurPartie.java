package quatredesuite_client.afficheurs.partie;

import java.util.List;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import quatredesuite.modeles.partie.ColonneLectureSeule;
import quatredesuite.modeles.partie.GrilleLectureSeule;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.vues.VuePartie;

public class AfficheurPartie extends Afficheur<PartieLectureSeule, VuePartie>{

	@Override
	public void initialiserAffichage(PartieLectureSeule partieLectureSeule, VuePartie vue) {
		J.appel(this);
		
		int largeur = partieLectureSeule.getLargeur();
		int hauteur = partieLectureSeule.getHauteur();
		
		vue.creerGrille(largeur, hauteur);
	}

	@Override
	public void rafraichirAffichage(PartieLectureSeule partieLectureSeule, VuePartie vue) {
		J.appel(this);

		GrilleLectureSeule grille = partieLectureSeule.getGrille();
		
		rafraichirGrille(grille, vue);
	}

	private void rafraichirGrille(GrilleLectureSeule grille, VuePartie vue) {
		J.appel(this);

		List<ColonneLectureSeule> colonnes = grille.getColonnes();
		
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
			
			// TODO

		}
	}

}
