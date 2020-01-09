package quatredesuite.messages.vers_client;


import commun.debogage.J;
import commun.messages.Message;
import quatredesuite.donnees.PartieReseau;

public class NouvellePartieReseau extends Message {
	
	private PartieReseau partie;
	
	public NouvellePartieReseau(PartieReseau partie) {
		J.appel(this);
		this.partie = partie;
	}
	
	public PartieReseau getPartie() {
		J.appel(this);
		
		return partie;
	}

}
