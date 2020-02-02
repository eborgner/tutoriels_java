package pong_client.commandes.reagir_temps_qui_passe;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class ReagirTempsQuiPasse extends Commande<ReagirTempsQuiPassePourEnvoi, 
												  ReagirTempsQuiPasseRecue> 

								 implements ReagirTempsQuiPassePourEnvoi, 
								 			ReagirTempsQuiPasseRecue {
	
	private double tempsEcouleSecondes;

	@Override
	public double getTempsEcouleSecondes() {
		J.appel(this);

		return tempsEcouleSecondes;
	}

	@Override
	public void setTempsEcouleSecondes(double tempsEcouleSecondes) {
		J.appel(this);
		
		this.tempsEcouleSecondes = tempsEcouleSecondes;
	}
	
}
