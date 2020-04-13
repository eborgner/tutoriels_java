package quatredesuite_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import quatredesuite.modeles.sauvegardes.SauvegardesLectureSeule;
import quatredesuite_client.vues.VueSauvegardes;

public abstract class AfficheurSauvegardes<V extends VueSauvegardes> 
       extends Afficheur<SauvegardesLectureSeule, V> {

	@Override
	public void initialiserAffichage(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);

	}

	@Override
	public void rafraichirAffichage(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);

	}

}
