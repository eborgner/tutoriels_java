package pong_client.commandes.deplacer_palette;

import commun.enumerations.Direction;
import commun_client.commandes.CommandeRecue;
import pong.enumerations.Cadran;

public interface DeplacerPaletteRecue extends CommandeRecue {

	Cadran getCadran();
	Direction getDirection();

}
