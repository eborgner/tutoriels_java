package tp01_menu_client.commandes.jouer_coup;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class JouerCoup extends Commande<JouerCoupPourEnvoi, 
                                       JouerCoupRecue> 

                      implements JouerCoupPourEnvoi, 
                                 JouerCoupRecue {
	
	private int info01;
	private String info02;
	
	
	@Override
	public int getInfo01() {
		J.appel(this);

		return info01;
	}

	@Override
	public void setInfo01(int info01) {
		J.appel(this);

		this.info01 = info01;
	}

	@Override
	public String getInfo02() {
		J.appel(this);

		return info02;
	}

	@Override
	public void setInfo02(String info02) {
		J.appel(this);

		this.info02 = info02;
	}
}
