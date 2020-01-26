package commun_client.evenements;

import commun.debogage.J;

public abstract class CapteurEvenement<EC extends EvenementCapte> {

	public abstract void capterEvenement(EC evenement);

	public boolean siCaptable(EC evenement) {
		J.appel(this);
		
		return true;
	}

}
