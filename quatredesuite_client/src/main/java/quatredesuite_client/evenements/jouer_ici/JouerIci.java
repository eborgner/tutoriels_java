package quatredesuite_client.evenements.jouer_ici;

import commun.debogage.J;
import commun_client.evenements.Evenement;

@SuppressWarnings("rawtypes")
public class JouerIci extends Evenement implements JouerIciLance, JouerIciCapte {
	
	private int idColonne;

	@Override
	public void setIdColonne(int idColonne) {
		J.appel(this);
		
		this.idColonne = idColonne;
	}

	@Override
	public int getIdColonne() {
		J.appel(this);

		return idColonne;
	}
	
}
