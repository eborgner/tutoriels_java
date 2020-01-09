package quatredesuite.messages.vers_client;

import commun.messages.Message;

public class CoupVersClient extends Message {
	
	private int indiceColonne;
	
	public CoupVersClient(int indiceColonne) {
		this.indiceColonne = indiceColonne;
	}

	public int getIndiceColonne() {
		return indiceColonne;
	}

}
