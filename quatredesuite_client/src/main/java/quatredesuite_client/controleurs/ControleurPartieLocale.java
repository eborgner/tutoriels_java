package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite.modeles.partie.PartieLocaleLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieLocale;
import quatredesuite_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale,
					       				     A extends AfficheurPartieLocale<V>> 

					extends ControleurModeleVue<PartieLocaleLectureSeule, 
											    PartieLocale, 
											    V, 
											    A> {
	
	@Override
	public void demarrer() {
		J.appel(this);

	}

	@Override
	public void installerReceptionCommandes() {
		J.appel(this);

	} 
}
