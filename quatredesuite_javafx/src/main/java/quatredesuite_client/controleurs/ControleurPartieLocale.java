package quatredesuite_client.controleurs;

import quatredesuite.modeles.partie_locale.PartieLocale;
import quatredesuite.modeles.partie_locale.PartieLocaleLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieLocale;
import quatredesuite_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale, 
                                             A extends AfficheurPartieLocale<V>>

                extends ControleurPartie<PartieLocaleLectureSeule, 
                                         PartieLocale, 
                                         V, 
                                         A> {
	
}
