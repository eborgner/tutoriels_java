package quatredesuite.modeles;

import commun.debogage.J;
import quatredesuite.donnees.PartieReseau;

public class ModelePartieReseau extends ModelePartie<PartieReseau>{

	public ModelePartieReseau(PartieReseau partie) {
		super(partie);
	}

	@Override
	protected PartieReseau creerPartie() {
		J.appel(this);
		return new PartieReseau();
	}
	
	
}
