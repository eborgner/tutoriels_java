package pong_client.commandes.deplacer_palette;

import commun.debogage.J;
import commun.enumerations.Direction;
import commun_client.commandes.Commande;
import pong.enumerations.Cadran;

public class DeplacerPalette extends Commande<DeplacerPalettePourEnvoi, 
											  DeplacerPaletteRecue>

							 implements DeplacerPalettePourEnvoi, 
							   			DeplacerPaletteRecue {
	
	private Cadran cadran;
	private Direction direction;

	@Override
	public Cadran getCadran() {
		J.appel(this);
		
		return cadran;
	}

	@Override
	public Direction getDirection() {
		J.appel(this);
		
		return direction;
	}

	@Override
	public void setCadran(Cadran cadran) {
		J.appel(this);
		
		this.cadran = cadran;
	}

	@Override
	public void setDirection(Direction direction) {
		J.appel(this);
		
		this.direction = direction;
	}
}
