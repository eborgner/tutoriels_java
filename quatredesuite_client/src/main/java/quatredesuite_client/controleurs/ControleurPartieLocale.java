package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite.modeles.partie.PartieLocaleLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieLocale;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<PartieLocaleLectureSeule, 
															    PartieLocale, 
															    VuePartieLocale, 
															    AfficheurPartieLocale> {
	
	@Override
	public void demarrer() {
		J.appel(this);
	} 
	
}
