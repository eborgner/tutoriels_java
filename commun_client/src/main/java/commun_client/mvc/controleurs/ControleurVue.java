package commun_client.mvc.controleurs;

import commun.debogage.J;
import commun_client.commandes.Commande;
import commun_client.commandes.CommandeRecue;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.ReactionVideParDefaut;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.Vue;

@SuppressWarnings("rawtypes")
public abstract class ControleurVue<V extends Vue> {
	
	protected V vue;
	
	public ControleurVue() {
		J.appel(this);
	}
	
	public void setVue(V vue) {
		J.appel(this);
		
		this.vue = vue;
	}
	
	protected void installerRecepteurCommande(Class<? extends Commande> classeCommande, 
											  RecepteurCommandeMVC<? extends CommandeRecue> recepteur) {
		J.appel(this);
		
		FabriqueCommande.installerRecepteur(classeCommande, (RecepteurCommande) recepteur);
		
		installerReactionApresCommande(classeCommande);
	}
	
	protected void installerReactionApresCommande(Class<? extends Commande> classeCommande) {
		J.appel(this);
		
		FabriqueCommande.installerReactionApresCommande(classeCommande, new ReactionVideParDefaut());
	}
	
	public abstract void installerReceptionCommandes();
	public abstract void demarrer();
	public abstract void detruire();

}
