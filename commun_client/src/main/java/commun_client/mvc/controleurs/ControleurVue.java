package commun_client.mvc.controleurs;

import commun.debogage.J;
import commun.messages.FabriqueMessage;
import commun.messages.Message;
import commun.messages.MessagePourEnvoi;
import commun.messages.MessageRecu;
import commun_client.commandes.Commande;
import commun_client.commandes.CommandePourEnvoi;
import commun_client.commandes.CommandeRecue;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.ReactionApresCommande;
import commun_client.commandes.ReactionVideParDefaut;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.Vue;

@SuppressWarnings("rawtypes")
public abstract class ControleurVue<V extends Vue> {
	
	protected V vue;
	
	protected ControleurVue() {
		J.appel(this);
	}
	
	void setVue(V vue) {
		J.appel(this);
		
		this.vue = vue;
	}
	
	protected <CPE extends CommandePourEnvoi,
			   CR extends CommandeRecue,
			   C extends Commande<CPE,CR>> 

			 void installerRecepteurCommande(Class<C> classeCommande, 
											  RecepteurCommandeMVC<CR> recepteur) {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(classeCommande, (RecepteurCommande<CR>) recepteur);
		
		installerReactionApresCommande(classeCommande);
	}
	
	protected <ME extends MessagePourEnvoi, 
	           MR extends MessageRecu,
	           M extends Message<ME, MR>>
	
			void installerRecepteurMessage(Class<M> classeMessage, RecepteurMessageMVC<MR> recepteur) {
		
		J.appel(this);
		
		recepteur.setControleur(this);

		FabriqueMessage.installerRecepteur(classeMessage, recepteur);
	}
	
	void installerReactionApresCommande(Class<? extends Commande> classeCommande) {
		J.appel(this);
		
		FabriqueCommande.installerReactionApresCommande(classeCommande, new ReactionApresCommande() {
			@Override
			public void reagirApresCommande() {
				J.appel(this);

				vue.verifierCommandesPossibles();
			}
		});
	}
	
	void notifierMessageTraite() {
		J.appel(this);
		
		return;
	}

	protected abstract void obtenirMessagesPourEnvoi();
	protected abstract void installerReceptionCommandes();
	protected abstract void installerReceptionMessages();
	protected abstract void demarrer();
}
