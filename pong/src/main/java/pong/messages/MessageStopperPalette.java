package pong.messages;


import commun.messages.Message;
import pong.enumerations.Cadran;

public class MessageStopperPalette extends Message {
	
	private Cadran cadran;

	public Cadran getCadran() {
		return cadran;
	}

	public void setCadran(Cadran cadran) {
		this.cadran = cadran;
	}
	
}
