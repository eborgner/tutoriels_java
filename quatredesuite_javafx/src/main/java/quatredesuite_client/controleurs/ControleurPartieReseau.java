package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun.messages.FabriqueMessage;
import commun_client.mvc.controleurs.RecepteurMessageMVC;
import quatredesuite.messages.transmettre_coup.TransmettreCoup;
import quatredesuite.messages.transmettre_coup.TransmettreCoupPourEnvoi;
import quatredesuite.messages.transmettre_coup.TransmettreCoupRecu;
import quatredesuite.modeles.partie_reseau.PartieReseau;
import quatredesuite.modeles.partie_reseau.PartieReseauLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartieReseau;
import quatredesuite_client.commandes.jouer_ici.JouerIciRecue;
import quatredesuite_client.vues.VuePartieReseau;

public abstract class ControleurPartieReseau<V extends VuePartieReseau, 
                                             A extends AfficheurPartieReseau<V>>

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        V, 
                        A> {
	
	private TransmettreCoupPourEnvoi transmettreCoup;
	

	@Override
	protected void obtenirMessagesPourEnvoi() {
		super.obtenirMessagesPourEnvoi();
		J.appel(this);
		
		transmettreCoup = FabriqueMessage.obtenirMessagePourEnvoi(TransmettreCoup.class);
	}

	@Override
	protected void installerReceptionMessages() {
		super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(TransmettreCoup.class, new RecepteurMessageMVC<TransmettreCoupRecu>() {

			@Override
			public void recevoirMessageMVC(TransmettreCoupRecu messageRecu) {
				J.appel(this);
				
				modele.jouerIci(messageRecu.getIndiceColonne());
			}
		});
	}
	
	@Override
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		super.reagirCommandeJouerIci(jouerIciRecue);
		J.appel(this);
		
		transmettreCoup.setIndiceColonne(jouerIciRecue.getIndiceColonne());
		transmettreCoup.envoyerMessage();
	}
}
