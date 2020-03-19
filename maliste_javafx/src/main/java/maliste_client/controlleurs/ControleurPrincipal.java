package maliste_client.controlleurs;

import maliste_client.afficheurs.AfficheurPrincipal;
import maliste_client.commandes.nouvel_item.NouvelItem;
import maliste_client.commandes.nouvel_item.NouvelItemRecue;
import maliste_client.commandes.retirer_item.RetirerItem;
import maliste_client.commandes.retirer_item.RetirerItemRecue;
import commun.debogage.J;
import commun.messages.FabriqueMessage;
import commun.messages.RecepteurMessage;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import maliste.messages.msg_nouvel_item.MsgNouvelItem;
import maliste.messages.msg_nouvel_item.MsgNouvelItemPourEnvoi;
import maliste.messages.msg_nouvel_item.MsgNouvelItemRecu;
import maliste.modeles.liste.Item;
import maliste.modeles.liste.Liste;
import maliste.modeles.liste.ListeLectureSeule;
import maliste_client.vues.VuePrincipale;

public abstract class ControleurPrincipal<V extends VuePrincipale, A extends AfficheurPrincipal<V>>
                extends ControleurModeleVue<ListeLectureSeule,
                                            Liste,
                                            V,
                                            A> {
	
	private MsgNouvelItemPourEnvoi nouvelItemPourEnvoi;

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
		nouvelItemPourEnvoi = FabriqueMessage.obtenirMessagePourEnvoi(MsgNouvelItem.class);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(NouvelItem.class, new RecepteurCommandeMVC<NouvelItemRecue>() {

			@Override
			public void executerCommandeMVC(NouvelItemRecue commande) {
				J.appel(this);
				
				Item item = modele.ajouterItem(commande.getTexte());
				
				nouvelItemPourEnvoi.setItem(item);
				nouvelItemPourEnvoi.envoyerMessage();
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
	protected void installerReceptionMessages() {
		J.appel(this);
		
		// FIXME: devrait être MVC aussi
		FabriqueMessage.installerRecepteur(MsgNouvelItem.class, new RecepteurMessage<MsgNouvelItemRecu>() {

			@Override
			public void recevoirMessage(MsgNouvelItemRecu messageRecu) {
				J.appel(this);
				
				modele.ajouterItem(messageRecu.getItem());
				
				// FIXME: devrait se faire auto avec une RecepteurMVC
				afficheur.rafraichirAffichage(modele, vue);
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);
		
		modele.ajouterItem("un test");
		modele.ajouterItem("un autre test");
		modele.ajouterItem("répéter:");
		modele.ajouterItem("un test");
		
		afficheur.initialiserAffichage(modele, vue);
	}
}
