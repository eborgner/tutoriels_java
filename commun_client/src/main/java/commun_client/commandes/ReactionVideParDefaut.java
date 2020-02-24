package commun_client.commandes;

import commun.debogage.J;

public class ReactionVideParDefaut extends ReactionApresCommande {

	@Override
	public void reagirApresCommande() {
		J.appel(this);
		
		// rien
	}


}
