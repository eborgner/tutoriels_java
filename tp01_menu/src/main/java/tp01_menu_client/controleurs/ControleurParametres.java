package tp01_menu_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import tp01_menu.modeles.parametres.Parametres;
import tp01_menu.modeles.parametres.ParametresLectureSeule;
import tp01_menu_client.afficheurs.AfficheurParametres;
import tp01_menu_client.vues.VueParametres;

public abstract class ControleurParametres<V extends VueParametres,
					       				     A extends AfficheurParametres<V>> 

					extends ControleurModeleVue<ParametresLectureSeule, 
											    Parametres, 
											    V, 
											    A> {
	

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	} 
}
