package maliste_client.controlleurs;

import maliste_client.afficheurs.AfficheurPrincipal;
import maliste_client.commandes.nouvel_item.NouvelItem;
import maliste_client.commandes.nouvel_item.NouvelItemRecue;
import maliste_client.commandes.retirer_item.RetirerItem;
import maliste_client.commandes.retirer_item.RetirerItemRecue;
import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import maliste.modeles.liste.Liste;
import maliste.modeles.liste.ListeLectureSeule;
import maliste_client.vues.VuePrincipale;

public abstract class ControleurPrincipal<V extends VuePrincipale, A extends AfficheurPrincipal<V>>
                extends ControleurModeleVue<ListeLectureSeule,
                                            Liste,
                                            V,
                                            A> {

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(NouvelItem.class, new RecepteurCommandeMVC<NouvelItemRecue>() {

			@Override
			public void executerCommandeMVC(NouvelItemRecue commande) {
				J.appel(this);
				
				modele.ajouterItem(commande.getTexte());
			}
		});
		
		installerRecepteurCommande(RetirerItem.class, new RecepteurCommandeMVC<RetirerItemRecue>() {

			@Override
			public void executerCommandeMVC(RetirerItemRecue commande) {
				J.appel(this);
				
				modele.retirerItem(commande.getId());
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	}
}
