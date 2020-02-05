package quatredesuite_client.commandes.jouer_ici;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class JouerIci extends Commande<JouerIciPourEnvoi, 
                                       JouerIciRecue> 

                      implements JouerIciPourEnvoi, 
                                 JouerIciRecue {
	
	private int indiceColonne;

	@Override
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}
}
