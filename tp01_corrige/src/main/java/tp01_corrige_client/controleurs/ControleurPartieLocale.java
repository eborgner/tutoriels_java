package tp01_corrige_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import tp01_corrige.modeles.partie.JetonLectureSeule;
import tp01_corrige.modeles.partie.PartieLocale;
import tp01_corrige.modeles.partie.PartieLocaleLectureSeule;
import tp01_corrige_client.afficheurs.AfficheurPartieLocale;
import tp01_corrige_client.commandes.jouer_ici.JouerIci;
import tp01_corrige_client.commandes.jouer_ici.JouerIciRecue;
import tp01_corrige_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale,
					       				     A extends AfficheurPartieLocale<V>> 

					extends ControleurModeleVue<PartieLocaleLectureSeule, 
											    PartieLocale, 
											    V, 
											    A> {
	
	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);

				modele.jouerIci(commande.getIndiceColonne());
			}
			
			@Override
			public boolean siCommandePossible(JouerIciRecue commande) {
				J.appel(this);
				
				return modele.siPossibleJouerIci(commande.getIndiceColonne());
			}
		});
	} 
}
