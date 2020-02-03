package pong_client.commandes.aggrandir_table_pong;

import commun.debogage.J;
import commun.enumerations.Dimension;
import commun_client.commandes.Commande;

public class AggrandirTablePong extends Commande<AggrandirTablePongPourEnvoi, 
										         AggrandirTablePongRecue>

								implements AggrandirTablePongPourEnvoi,
										   AggrandirTablePongRecue {
	
	private Dimension dimension;
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
	public Dimension getDimension() {
		J.appel(this);

		return dimension;
	}

	@Override
	public void setDimension(Dimension dimension) {
		J.appel(this);

		this.dimension = dimension;
	}
}
