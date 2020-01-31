package pong_client.commandes.aggrandir_table_pong;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class AggrandirTablePong extends Commande<AggrandirTablePongPourEnvoi, 
										         AggrandirTablePongRecue>

								implements AggrandirTablePongPourEnvoi,
										   AggrandirTablePongRecue {
	
	public enum Direction {
		LARGEUR, HAUTEUR;
	}
	
	private Direction direction;
	private double facteurAggrandissement;


	@Override
	public double getFacteurAggrandissement() {
		J.appel(this);

		return facteurAggrandissement;
	}

	@Override
	public void setFacteurAggrandissement(double facteurAggrandissement) {
		J.appel(this);
		
		this.facteurAggrandissement = facteurAggrandissement;
	}

	@Override
	public Direction getDirection() {
		J.appel(this);

		return direction;
	}

	@Override
	public void setDirection(Direction direction) {
		J.appel(this);

		this.direction = direction;
	}
}
