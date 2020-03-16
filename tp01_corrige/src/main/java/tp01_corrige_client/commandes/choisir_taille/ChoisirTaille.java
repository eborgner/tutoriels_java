package tp01_corrige_client.commandes.choisir_taille;

import commun.debogage.J;
import commun_client.commandes.Commande;
import tp01_corrige.enumerations.TailleGrille;

public class ChoisirTaille extends Commande<ChoisirTaillePourEnvoi, ChoisirTailleRecue> 
						   implements ChoisirTaillePourEnvoi, ChoisirTailleRecue {
	
	private TailleGrille taille;

	@Override
	public TailleGrille getTaille() {
		J.appel(this);
		
		return taille;
	}

	@Override
	public void setTaille(TailleGrille taille) {
		J.appel(this);
		
		this.taille = taille;
	}

}
