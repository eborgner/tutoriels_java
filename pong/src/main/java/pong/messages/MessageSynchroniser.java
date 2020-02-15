package pong.messages;

import java.util.Map;

import commun.debogage.J;
import commun.messages.Message;
import pong.enumerations.Cadran;
import pong.modeles.partie.table_pong.Balle;
import pong.modeles.partie.table_pong.Palette;

public class MessageSynchroniser extends Message {
	
	private Balle balle;
	private Map<Cadran, Palette> palettes;

	public void setBalle(Balle balle) {
		J.appel(this);
		
		this.balle = balle;
	}
	
	public Balle getBalle() {
		J.appel(this);
		
		return balle;
	}

	public Map<Cadran, Palette> getPalettes() {
		return palettes;
	}

	public void setPalettes(Map<Cadran, Palette> palettes) {
		this.palettes = palettes;
	}
}
