package tp01_menu_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import tp01_menu.modeles.parametres.ParametresLectureSeule;
import tp01_menu_client.vues.VueParametres;

public abstract class AfficheurParametres<V extends VueParametres> 

                            extends Afficheur<ParametresLectureSeule, 
                                              V> {

	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
	}

}
