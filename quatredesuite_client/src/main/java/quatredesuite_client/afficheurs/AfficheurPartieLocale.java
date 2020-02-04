package quatredesuite_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.vues.VuePartieLocale;

public class AfficheurPartieLocale extends Afficheur<PartieLectureSeule, VuePartieLocale>{

	@Override
	public void initialiserAffichage(PartieLectureSeule partieLectureSeule, VuePartieLocale vue) {
		J.appel(this);
		
		int largeur = partieLectureSeule.getLargeur();
		int hauteur = partieLectureSeule.getHauteur();

		vue.creerGrille(largeur, hauteur);
	}

}
