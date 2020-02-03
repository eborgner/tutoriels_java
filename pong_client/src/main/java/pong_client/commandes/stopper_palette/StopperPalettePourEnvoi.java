package pong_client.commandes.stopper_palette;

import commun_client.commandes.CommandePourEnvoi;
import pong.enumerations.Cadran;

public interface StopperPalettePourEnvoi extends CommandePourEnvoi {
	
	void setCadran(Cadran cadran);

}
