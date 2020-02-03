package pong_client.commandes.aggrandir_table_pong;

import commun.enumerations.Dimension;
import commun_client.commandes.CommandeRecue;

public interface AggrandirTablePongRecue extends CommandeRecue {
	
	Dimension getDimension();
	double getFacteurAggrandissement();

}
