package commun_client.evenements;

import commun.debogage.J;

public abstract class FinalisateurEvenement{

	public void reagirFinCaptation() {
		J.appel(this);
		
		// par défaut: rien
	}

}
