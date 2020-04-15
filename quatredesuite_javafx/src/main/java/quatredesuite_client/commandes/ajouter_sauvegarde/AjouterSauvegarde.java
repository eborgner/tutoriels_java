package quatredesuite_client.commandes.ajouter_sauvegarde;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class AjouterSauvegarde 
       extends    Commande<AjouterSauvegardePourEnvoi,
                        AjouterSauvegardeRecue>
	   implements AjouterSauvegardePourEnvoi,
	              AjouterSauvegardeRecue {
	
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
