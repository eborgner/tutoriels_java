package quatredesuite_client.commandes.jouer_ici;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class JouerIci extends Commande<JouerIciPourEnvoi, 
                                       JouerIciRecue> 

                      implements JouerIciPourEnvoi, 
                                 JouerIciRecue {
	
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
