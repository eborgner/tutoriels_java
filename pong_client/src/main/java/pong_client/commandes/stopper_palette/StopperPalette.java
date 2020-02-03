package pong_client.commandes.stopper_palette;

import commun.debogage.J;
import commun_client.commandes.Commande;
import pong.enumerations.Cadran;

public class StopperPalette extends Commande<StopperPalettePourEnvoi, 
 									         StopperPaletteRecue>

							implements StopperPalettePourEnvoi, 
							           StopperPaletteRecue {
	
	private Cadran cadran;

	@Override
	public Cadran getCadran() {
		J.appel(this);
		
		return cadran;
	}

	@Override
	public void setCadran(Cadran cadran) {
		J.appel(this);
		
		this.cadran = cadran;
	}
}
