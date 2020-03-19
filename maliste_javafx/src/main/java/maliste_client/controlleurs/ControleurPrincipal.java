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
import maliste.messages.ajouter_item.AjouterItem;
import maliste.messages.ajouter_item.AjouterItemPourEnvoi;
import maliste.messages.ajouter_item.AjouterItemRecu;
import maliste.messages.detruire_item.DetruireItem;
import maliste.messages.detruire_item.DetruireItemPourEnvoi;
import maliste.messages.detruire_item.DetruireItemRecu;
import maliste.modeles.liste.Item;
import maliste.modeles.liste.Liste;
import maliste.modeles.liste.ListeLectureSeule;
import maliste_client.vues.VuePrincipale;

public abstract class ControleurPrincipal<V extends VuePrincipale, A extends AfficheurPrincipal<V>>
                extends ControleurModeleVue<ListeLectureSeule,
                                            Liste,
                                            V,
                                            A> {
	
	private AjouterItemPourEnvoi ajouterItemPourEnvoi;
	private DetruireItemPourEnvoi detruireItemPourEnvoi;

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
		ajouterItemPourEnvoi = FabriqueMessage.obtenirMessagePourEnvoi(AjouterItem.class);
		detruireItemPourEnvoi = FabriqueMessage.obtenirMessagePourEnvoi(DetruireItem.class);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(NouvelItem.class, new RecepteurCommandeMVC<NouvelItemRecue>() {

			@Override
			public void executerCommandeMVC(NouvelItemRecue commande) {
				J.appel(this);
				
				Item item = modele.ajouterItem(commande.getTexte());
				
				ajouterItemPourEnvoi.setItem(item);
				ajouterItemPourEnvoi.envoyerMessage();
			}
		});
		
		installerRecepteurCommande(RetirerItem.class, new RecepteurCommandeMVC<RetirerItemRecue>() {

			@Override
			public void executerCommandeMVC(RetirerItemRecue commande) {
				J.appel(this);
				
				modele.retirerItem(commande.getId());
				
				detruireItemPourEnvoi.setId(commande.getId());
				detruireItemPourEnvoi.envoyerMessage();
			}
		});
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
		// FIXME: devrait être MVC aussi
		FabriqueMessage.installerRecepteur(AjouterItem.class, new RecepteurMessage<AjouterItemRecu>() {

			@Override
			public void recevoirMessage(AjouterItemRecu messageRecu) {
				J.appel(this);
				
				modele.ajouterItem(messageRecu.getItem());
				
				// FIXME: devrait se faire auto avec une RecepteurMVC
				afficheur.rafraichirAffichage(modele, vue);
			}
		});

		// FIXME: devrait être MVC aussi
		FabriqueMessage.installerRecepteur(DetruireItem.class, new RecepteurMessage<DetruireItemRecu>() {

			@Override
			public void recevoirMessage(DetruireItemRecu messageRecu) {
				J.appel(this);
				
				modele.retirerItem(messageRecu.getId());
				
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
