package pong.messages;

import commun.debogage.J;
import commun.messages.Message;
import pong.modeles.partie.table_pong.Balle;

public class MessageDebutPartie extends Message {
	
	private Balle balle;

	public void setBalle(Balle balle) {
		J.appel(this);
		
		this.balle = balle;
	}
	
	public Balle getBalle() {
		J.appel(this);
		
		return balle;
	}
	
}
