package commun_client.commandes;

import commun.debogage.J;

public abstract class ReactionApresCommande{

	public void reagirMessageTraite() {
		J.appel(this);
		
		// par défaut: rien
	}

}
