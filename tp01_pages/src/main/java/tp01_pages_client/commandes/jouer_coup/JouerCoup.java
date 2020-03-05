package tp01_pages_client.commandes.jouer_coup;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class JouerCoup extends Commande<JouerCoupPourEnvoi, 
                                       JouerCoupRecue> 

                      implements JouerCoupPourEnvoi, 
                                 JouerCoupRecue {
	
	private int infoCoup;

	@Override
	public int getInfoCoup() {
		J.appel(this);

		return infoCoup;
	}

	@Override
	public void setInfoCoup(int infoCoup) {
		J.appel(this);

		this.infoCoup = infoCoup;
	}
}
