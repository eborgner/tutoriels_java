package pong_client.commandes.stopper_palette;

import commun_client.commandes.CommandeRecue;
import pong.enumerations.Cadran;

public interface StopperPaletteRecue extends CommandeRecue {
	
	Cadran getCadran();

}
