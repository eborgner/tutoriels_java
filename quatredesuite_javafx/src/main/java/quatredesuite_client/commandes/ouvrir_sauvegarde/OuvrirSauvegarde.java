package quatredesuite_client.commandes.ouvrir_sauvegarde;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class OuvrirSauvegarde 
       extends    Commande<OuvrirSauvegardePourEnvoi,
                        OuvrirSauvegardeRecue>
	   implements OuvrirSauvegardePourEnvoi,
	              OuvrirSauvegardeRecue {
	
	private String cheminDansHome;

	@Override
	public String getCheminDansHome() {
		J.appel(this);
		
		return cheminDansHome;
	}

	@Override
	public void setCheminDansHome(String cheminDansHome) {
		J.appel(this);
		
		this.cheminDansHome = cheminDansHome;
	}

}
