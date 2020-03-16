package tp01_corrige_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import tp01_corrige.modeles.parametres.ParametresLectureSeule;
import tp01_corrige_client.vues.VueParametres;

public abstract class AfficheurParametres<V extends VueParametres> 

                            extends Afficheur<ParametresLectureSeule, 
                                              V> {

	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
		vue.afficherTaille(modeleLectureSeule.getTailleGrille());
	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);

		vue.afficherTaille(modeleLectureSeule.getTailleGrille());
	}

}
