package pong_client.commandes.aggrandir_table_pong;

import commun_client.commandes.CommandeRecue;

public interface AggrandirTablePongRecue extends CommandeRecue {
	
	AggrandirTablePong.Direction getDirection();
	double getFacteurAggrandissement();

}
