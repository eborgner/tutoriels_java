package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieLocale;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<PartieLectureSeule, 
															    PartieLocale, 
															    VuePartieLocale, 
															    AfficheurPartieLocale> {
	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	}

	@Override
	public void demarrer() {
		J.appel(this);
	} 
	
}
