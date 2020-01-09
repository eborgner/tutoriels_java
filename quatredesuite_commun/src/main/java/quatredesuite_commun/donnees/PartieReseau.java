package quatredesuite.donnees;

import commun.debogage.J;

public class PartieReseau extends Partie {
	
	private String id = "idPartie";
	
	public String getId() {
		J.appel(this);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
