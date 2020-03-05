package tp01_une_page_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import tp01_une_page.modeles.partie_locale.PartieLocale;
import tp01_une_page.modeles.partie_locale.PartieLocaleLectureSeule;
import tp01_une_page_client.afficheurs.AfficheurPartieLocale;
import tp01_une_page_client.commandes.jouer_coup.JouerCoup;
import tp01_une_page_client.commandes.jouer_coup.JouerCoupRecue;
import tp01_une_page_client.vues.VuePartieLocale;

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
		
		installerRecepteurCommande(JouerCoup.class, new RecepteurCommandeMVC<JouerCoupRecue>() {
			@Override
			public void executerCommandeMVC(JouerCoupRecue commande) {
				J.appel(this);
				
				modele.jouerCoup(commande.getInfoCoup());
			}
		});
	} 
}
