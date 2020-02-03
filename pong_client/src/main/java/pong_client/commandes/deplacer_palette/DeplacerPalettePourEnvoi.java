package pong_client.commandes.deplacer_palette;

import commun.enumerations.Direction;
import commun_client.commandes.CommandePourEnvoi;
import pong.enumerations.Cadran;

public interface DeplacerPalettePourEnvoi extends CommandePourEnvoi { 
	
	void setCadran(Cadran cadran);
	void setDirection(Direction direction);
	
	
}
