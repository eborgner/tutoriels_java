package quatredesuite_client.controleurs;

import quatredesuite.modeles.partie_reseau.PartieReseau;
import quatredesuite.modeles.partie_reseau.PartieReseauLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieReseau;
import quatredesuite_client.vues.VuePartieReseau;

public abstract class ControleurPartieReseau <V extends VuePartieReseau, A extends AfficheurPartieReseau<V>>

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        V, 
                        A> {
	
}
