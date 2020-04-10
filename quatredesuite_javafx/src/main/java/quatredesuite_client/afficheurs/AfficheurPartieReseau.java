package quatredesuite_client.afficheurs;

import quatredesuite.modeles.partie_locale.PartieLocaleLectureSeule;
import quatredesuite.modeles.partie_reseau.PartieReseauLectureSeule;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_client.vues.VuePartieReseau;

public abstract class AfficheurPartieReseau<V extends VuePartieReseau>

                extends AfficheurPartie<PartieReseauLectureSeule, V>  {

}
