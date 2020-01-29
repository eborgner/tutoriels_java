package commun_client.commandes;

import commun.debogage.J;

public abstract class RecepteurCommande<EC extends CommandeRecue> {

	public abstract void capterEvenement(EC evenement);

	public boolean siCaptable(EC evenement) {
		J.appel(this);
		
		return true;
	}

}
