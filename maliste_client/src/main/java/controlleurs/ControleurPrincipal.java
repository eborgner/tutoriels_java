package controlleurs;

import afficheurs.AfficheurPrincipal;
import commandes.nouvel_item.NouvelItem;
import commandes.nouvel_item.NouvelItemRecue;
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
		
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	}
}
