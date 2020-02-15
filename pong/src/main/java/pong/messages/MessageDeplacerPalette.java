package pong.messages;


import commun.enumerations.Direction;
import commun.messages.Message;
import pong.enumerations.Cadran;

public class MessageDeplacerPalette extends Message {
	
	private Cadran cadran;
	private Direction direction;

	public Cadran getCadran() {
		return cadran;
	}

	public void setCadran(Cadran cadran) {
		this.cadran = cadran;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
}
