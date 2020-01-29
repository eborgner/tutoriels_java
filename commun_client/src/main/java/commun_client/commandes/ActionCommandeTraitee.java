package commun_client.commandes;

import commun.debogage.J;

public abstract class ActionCommandeTraitee{

	public void reagirMessageTraite() {
		J.appel(this);
		
		// par défaut: rien
	}

}
